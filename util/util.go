// Copyright (c) 2023, donnie <donnie4w@gmail.com>
// All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.
//
// github.com/donnie4w/tim

package util

import (
	"errors"
	"fmt"
	"github.com/donnie4w/gofer/base58"
	"github.com/donnie4w/gofer/buffer"
	"github.com/donnie4w/gofer/keystore"
	goutil "github.com/donnie4w/gofer/util"
	"github.com/donnie4w/tim/log"
	. "github.com/donnie4w/tim/stub"
	"github.com/donnie4w/tim/sys"
	"golang.org/x/crypto/bcrypt"
	"strings"
)

//var GoPool = gopool.NewPool(100, 100<<3)
//var GoPoolTx = gopool.NewPool(int64(runtime.NumCPU()), int64(runtime.NumCPU())<<2)
//var GoPoolTx2 = gopool.NewPool(int64(runtime.NumCPU()), int64(runtime.NumCPU())<<3)

func CreateUUIDByTid(tid *Tid) uint64 {
	return CreateUUID(tid.Node, tid.Domain)
}

func CreateUUID(name string, domain *string) uint64 {
	buf := buffer.NewBufferByPool()
	defer buf.Free()
	buf.WriteString(name)
	buf.WriteString(sys.Conf.Salt)
	if domain != nil && *domain != "" {
		buf.WriteString(*domain)
	}
	u := goutil.CRC64(buf.Bytes())
	bs := goutil.Int64ToBytes(int64(u))
	_bs := MaskWithSeed(bs, Mask(sys.MaskSeed))
	b8 := goutil.CRC8(_bs[:7])
	bs[7] = b8
	return uint64(goutil.BytesToInt64(bs))
}

func NewTimUUID() uint64 {
	buf := buffer.NewBufferWithCapacity(len(sys.Conf.Salt) + 8)
	buf.WriteString(sys.Conf.Salt)
	buf.Write(goutil.Int64ToBytes(goutil.UUID64()))
	return CreateUUID(string(buf.Bytes()), nil)
}

func NameToNode(name string, domain *string) string {
	return UUIDToNode(CreateUUID(name, domain))
}

func NodeToUUID(node string) (_r uint64) {
	_r, _ = base58.DecodeForInt64([]byte(node))
	return
}

func UUIDToNode(uuid uint64) string {
	return string(base58.EncodeForInt64(uuid))
}

func CheckUUID(uuid uint64) bool {
	bs := goutil.Int64ToBytes(int64(uuid))
	_bs := MaskWithSeed(bs, Mask(sys.MaskSeed))
	b8 := goutil.CRC8(_bs[:7])
	return b8 == bs[7]
}

func CheckNode(node string) bool {
	if len(node) <= sys.NodeMaxSize {
		if _r := NodeToUUID(node); _r > 0 {
			return CheckUUID(_r)
		}
	}
	return false
}

func CheckNodes(nodes ...string) bool {
	if len(nodes) == 0 {
		return false
	}
	for _, node := range nodes {
		if !CheckNode(node) {
			return false
		}
	}
	return true
}

func ChatIdByRoom(node string, domain *string) []byte {
	var r [16]byte
	uuidBs := goutil.Int64ToBytes(int64(CreateUUID(node, domain)))
	copy(r[0:8], uuidBs)
	return r[:]
}

func ChatIdByNode(fromNode, toNode string, domain *string) []byte {
	var r [16]byte
	f, t := CreateUUID(fromNode, domain), CreateUUID(toNode, domain)
	if f < t {
		f, t = t, f
	}
	copy(r[0:8], goutil.Int64ToBytes(int64(f)))
	copy(r[8:16], goutil.Int64ToBytes(int64(t)))
	return r[:]
}

func RelateIdForGroup(groupNode, userNode string, domain *string) []byte {
	var r [16]byte
	f, t := CreateUUID(groupNode, domain), CreateUUID(userNode, domain)
	if f < t {
		f, t = t, f
	}
	copy(r[0:8], goutil.Int64ToBytes(int64(f)))
	copy(r[8:16], goutil.Int64ToBytes(int64(t)))
	return r[:]
}

func UnikId(f, t uint64) []byte {
	var r [16]byte
	if f < t {
		f, t = t, f
	}
	copy(r[0:8], goutil.Int64ToBytes(int64(f)))
	copy(r[8:16], goutil.Int64ToBytes(int64(t)))
	return r[:]
}

func UnikIdByNode(fromNode, toNode string, domain *string) []byte {
	var r [16]byte
	f, t := CreateUUID(fromNode, domain), CreateUUID(toNode, domain)
	copy(r[0:8], goutil.Int64ToBytes(int64(f)))
	copy(r[8:16], goutil.Int64ToBytes(int64(t)))
	return r[:]
}

func Password(uuid uint64, pwd string, domain *string) (string, error) {
	hash, err := bcrypt.GenerateFromPassword(passwordBytes(uuid, pwd, domain), bcrypt.DefaultCost)
	if err != nil {
		return "", err
	}
	return string(hash), nil
}

func passwordBytes(uuid uint64, pwd string, domain *string) []byte {
	buf := buffer.NewBufferByPool()
	defer buf.Free()
	buf.Write(goutil.Int64ToBytes(int64(uuid)))
	buf.WriteString(sys.Conf.Salt)
	if domain != nil {
		buf.WriteString(*domain)
	}
	buf.Write([]byte(pwd))
	return buf.Bytes()
}

func CheckPasswordHash(uuid uint64, pwd string, domain *string, hash string) bool {
	return bcrypt.CompareHashAndPassword([]byte(hash), passwordBytes(uuid, pwd, domain)) == nil
}

func MaskId(id int64) (_r int64) {
	ids := goutil.Int64ToBytes(id)
	return goutil.BytesToInt64(Mask(ids))
}

func Mask(bs []byte) (_r []byte) {
	if bs != nil {
		_r = make([]byte, len(bs))
		for i, j := 0, 0; i < len(bs); i++ {
			_r[i] = bs[i] ^ sys.MaskSeed[j]
			j = i % 8
		}
	}
	return
}

func MaskStr(s string) (_r string) {
	return string(Mask([]byte(s)))
}

func MaskTid(tid *Tid) {
	if tid != nil {
		tid.Node = MaskStr(tid.Node)
	}
}

func MaskWithSeed(bs []byte, seed []byte) (_r []byte) {
	_r = make([]byte, len(bs))
	for i, j := 0, 0; i < len(bs); i++ {
		_r[i] = bs[i] ^ seed[j]
		j = i % len(seed)
	}
	return
}

func ParseAddr(addr string) (_r string, err error) {
	if _r = addr; !strings.Contains(_r, ":") {
		if goutil.MatchString("^[0-9]{4,5}$", addr) {
			_r = ":" + _r
		} else {
			err = errors.New("error format :" + addr)
		}
	}
	return
}

func JTP(b byte) bool {
	return b&0x80 == 0x80
}

func ArraySub2[K int | int8 | int32 | int64 | string](a []K, k K) (_r []K) {
	if a != nil {
		_r = make([]K, 0)
		for _, v := range a {
			if v != k {
				_r = append(_r, v)
			}
		}
	}
	return
}

func ArraySub[K int | int8 | int32 | int64 | string](a1, a2 []K) (_r []K) {
	_r = make([]K, 0)
	if a1 != nil && a2 != nil {
		m := make(map[K]byte, 0)
		for _, a := range a2 {
			m[a] = 0
		}
		for _, a := range a1 {
			if _, ok := m[a]; !ok {
				_r = append(_r, a)
			}
		}
	} else if a2 == nil {
		return a1
	}
	return
}

func Recover() {
	if err := recover(); err != nil {
		log.Error(err)
	}
}

func Recover2(err *error) {
	if e := recover(); e != nil {
		if err != nil {
			*err = errors.New(fmt.Sprint(e))
		}
	}
}

func AesEncode(bs []byte) ([]byte, error) {
	return keystore.AesEncrypter(bs, sys.Conf.EncryptKey)
}

func AesDecode(bs []byte) ([]byte, error) {
	return keystore.AesDecrypter(bs, sys.Conf.EncryptKey)
}

func ContainStrings(li []string, v string) (b bool) {
	for _, item := range li {
		if item == v {
			return true
		}
	}
	return false
}

func ContainInt[T int64 | uint64 | int | uint | uint32 | int32](li []T, v T) (b bool) {
	for _, item := range li {
		if item == v {
			return true
		}
	}
	return false
}
