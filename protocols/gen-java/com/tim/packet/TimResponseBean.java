/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.tim.packet;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-09-21")
public class TimResponseBean implements org.apache.thrift.TBase<TimResponseBean, TimResponseBean._Fields>, java.io.Serializable, Cloneable, Comparable<TimResponseBean> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TimResponseBean");

  private static final org.apache.thrift.protocol.TField THREAD_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("threadId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ERROR_FIELD_DESC = new org.apache.thrift.protocol.TField("error", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField EXTRA_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("extraList", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField EXTRA_MAP_FIELD_DESC = new org.apache.thrift.protocol.TField("extraMap", org.apache.thrift.protocol.TType.MAP, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TimResponseBeanStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TimResponseBeanTupleSchemeFactory());
  }

  public String threadId; // optional
  /**
   * 错误码
   */
  public TimError error; // optional
  /**
   * 附加信息
   */
  public List<TimNode> extraList; // optional
  public Map<String,String> extraMap; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    THREAD_ID((short)1, "threadId"),
    /**
     * 错误码
     */
    ERROR((short)2, "error"),
    /**
     * 附加信息
     */
    EXTRA_LIST((short)3, "extraList"),
    EXTRA_MAP((short)4, "extraMap");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // THREAD_ID
          return THREAD_ID;
        case 2: // ERROR
          return ERROR;
        case 3: // EXTRA_LIST
          return EXTRA_LIST;
        case 4: // EXTRA_MAP
          return EXTRA_MAP;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.THREAD_ID,_Fields.ERROR,_Fields.EXTRA_LIST,_Fields.EXTRA_MAP};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.THREAD_ID, new org.apache.thrift.meta_data.FieldMetaData("threadId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ERROR, new org.apache.thrift.meta_data.FieldMetaData("error", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TimError.class)));
    tmpMap.put(_Fields.EXTRA_LIST, new org.apache.thrift.meta_data.FieldMetaData("extraList", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TimNode.class))));
    tmpMap.put(_Fields.EXTRA_MAP, new org.apache.thrift.meta_data.FieldMetaData("extraMap", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TimResponseBean.class, metaDataMap);
  }

  public TimResponseBean() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TimResponseBean(TimResponseBean other) {
    if (other.isSetThreadId()) {
      this.threadId = other.threadId;
    }
    if (other.isSetError()) {
      this.error = new TimError(other.error);
    }
    if (other.isSetExtraList()) {
      List<TimNode> __this__extraList = new ArrayList<TimNode>(other.extraList.size());
      for (TimNode other_element : other.extraList) {
        __this__extraList.add(new TimNode(other_element));
      }
      this.extraList = __this__extraList;
    }
    if (other.isSetExtraMap()) {
      Map<String,String> __this__extraMap = new HashMap<String,String>(other.extraMap);
      this.extraMap = __this__extraMap;
    }
  }

  public TimResponseBean deepCopy() {
    return new TimResponseBean(this);
  }

  @Override
  public void clear() {
    this.threadId = null;
    this.error = null;
    this.extraList = null;
    this.extraMap = null;
  }

  public String getThreadId() {
    return this.threadId;
  }

  public TimResponseBean setThreadId(String threadId) {
    this.threadId = threadId;
    return this;
  }

  public void unsetThreadId() {
    this.threadId = null;
  }

  /** Returns true if field threadId is set (has been assigned a value) and false otherwise */
  public boolean isSetThreadId() {
    return this.threadId != null;
  }

  public void setThreadIdIsSet(boolean value) {
    if (!value) {
      this.threadId = null;
    }
  }

  /**
   * 错误码
   */
  public TimError getError() {
    return this.error;
  }

  /**
   * 错误码
   */
  public TimResponseBean setError(TimError error) {
    this.error = error;
    return this;
  }

  public void unsetError() {
    this.error = null;
  }

  /** Returns true if field error is set (has been assigned a value) and false otherwise */
  public boolean isSetError() {
    return this.error != null;
  }

  public void setErrorIsSet(boolean value) {
    if (!value) {
      this.error = null;
    }
  }

  public int getExtraListSize() {
    return (this.extraList == null) ? 0 : this.extraList.size();
  }

  public java.util.Iterator<TimNode> getExtraListIterator() {
    return (this.extraList == null) ? null : this.extraList.iterator();
  }

  public void addToExtraList(TimNode elem) {
    if (this.extraList == null) {
      this.extraList = new ArrayList<TimNode>();
    }
    this.extraList.add(elem);
  }

  /**
   * 附加信息
   */
  public List<TimNode> getExtraList() {
    return this.extraList;
  }

  /**
   * 附加信息
   */
  public TimResponseBean setExtraList(List<TimNode> extraList) {
    this.extraList = extraList;
    return this;
  }

  public void unsetExtraList() {
    this.extraList = null;
  }

  /** Returns true if field extraList is set (has been assigned a value) and false otherwise */
  public boolean isSetExtraList() {
    return this.extraList != null;
  }

  public void setExtraListIsSet(boolean value) {
    if (!value) {
      this.extraList = null;
    }
  }

  public int getExtraMapSize() {
    return (this.extraMap == null) ? 0 : this.extraMap.size();
  }

  public void putToExtraMap(String key, String val) {
    if (this.extraMap == null) {
      this.extraMap = new HashMap<String,String>();
    }
    this.extraMap.put(key, val);
  }

  public Map<String,String> getExtraMap() {
    return this.extraMap;
  }

  public TimResponseBean setExtraMap(Map<String,String> extraMap) {
    this.extraMap = extraMap;
    return this;
  }

  public void unsetExtraMap() {
    this.extraMap = null;
  }

  /** Returns true if field extraMap is set (has been assigned a value) and false otherwise */
  public boolean isSetExtraMap() {
    return this.extraMap != null;
  }

  public void setExtraMapIsSet(boolean value) {
    if (!value) {
      this.extraMap = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case THREAD_ID:
      if (value == null) {
        unsetThreadId();
      } else {
        setThreadId((String)value);
      }
      break;

    case ERROR:
      if (value == null) {
        unsetError();
      } else {
        setError((TimError)value);
      }
      break;

    case EXTRA_LIST:
      if (value == null) {
        unsetExtraList();
      } else {
        setExtraList((List<TimNode>)value);
      }
      break;

    case EXTRA_MAP:
      if (value == null) {
        unsetExtraMap();
      } else {
        setExtraMap((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case THREAD_ID:
      return getThreadId();

    case ERROR:
      return getError();

    case EXTRA_LIST:
      return getExtraList();

    case EXTRA_MAP:
      return getExtraMap();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case THREAD_ID:
      return isSetThreadId();
    case ERROR:
      return isSetError();
    case EXTRA_LIST:
      return isSetExtraList();
    case EXTRA_MAP:
      return isSetExtraMap();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TimResponseBean)
      return this.equals((TimResponseBean)that);
    return false;
  }

  public boolean equals(TimResponseBean that) {
    if (that == null)
      return false;

    boolean this_present_threadId = true && this.isSetThreadId();
    boolean that_present_threadId = true && that.isSetThreadId();
    if (this_present_threadId || that_present_threadId) {
      if (!(this_present_threadId && that_present_threadId))
        return false;
      if (!this.threadId.equals(that.threadId))
        return false;
    }

    boolean this_present_error = true && this.isSetError();
    boolean that_present_error = true && that.isSetError();
    if (this_present_error || that_present_error) {
      if (!(this_present_error && that_present_error))
        return false;
      if (!this.error.equals(that.error))
        return false;
    }

    boolean this_present_extraList = true && this.isSetExtraList();
    boolean that_present_extraList = true && that.isSetExtraList();
    if (this_present_extraList || that_present_extraList) {
      if (!(this_present_extraList && that_present_extraList))
        return false;
      if (!this.extraList.equals(that.extraList))
        return false;
    }

    boolean this_present_extraMap = true && this.isSetExtraMap();
    boolean that_present_extraMap = true && that.isSetExtraMap();
    if (this_present_extraMap || that_present_extraMap) {
      if (!(this_present_extraMap && that_present_extraMap))
        return false;
      if (!this.extraMap.equals(that.extraMap))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_threadId = true && (isSetThreadId());
    list.add(present_threadId);
    if (present_threadId)
      list.add(threadId);

    boolean present_error = true && (isSetError());
    list.add(present_error);
    if (present_error)
      list.add(error);

    boolean present_extraList = true && (isSetExtraList());
    list.add(present_extraList);
    if (present_extraList)
      list.add(extraList);

    boolean present_extraMap = true && (isSetExtraMap());
    list.add(present_extraMap);
    if (present_extraMap)
      list.add(extraMap);

    return list.hashCode();
  }

  @Override
  public int compareTo(TimResponseBean other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetThreadId()).compareTo(other.isSetThreadId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetThreadId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.threadId, other.threadId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetError()).compareTo(other.isSetError());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetError()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.error, other.error);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExtraList()).compareTo(other.isSetExtraList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExtraList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.extraList, other.extraList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExtraMap()).compareTo(other.isSetExtraMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExtraMap()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.extraMap, other.extraMap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TimResponseBean(");
    boolean first = true;

    if (isSetThreadId()) {
      sb.append("threadId:");
      if (this.threadId == null) {
        sb.append("null");
      } else {
        sb.append(this.threadId);
      }
      first = false;
    }
    if (isSetError()) {
      if (!first) sb.append(", ");
      sb.append("error:");
      if (this.error == null) {
        sb.append("null");
      } else {
        sb.append(this.error);
      }
      first = false;
    }
    if (isSetExtraList()) {
      if (!first) sb.append(", ");
      sb.append("extraList:");
      if (this.extraList == null) {
        sb.append("null");
      } else {
        sb.append(this.extraList);
      }
      first = false;
    }
    if (isSetExtraMap()) {
      if (!first) sb.append(", ");
      sb.append("extraMap:");
      if (this.extraMap == null) {
        sb.append("null");
      } else {
        sb.append(this.extraMap);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (error != null) {
      error.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TimResponseBeanStandardSchemeFactory implements SchemeFactory {
    public TimResponseBeanStandardScheme getScheme() {
      return new TimResponseBeanStandardScheme();
    }
  }

  private static class TimResponseBeanStandardScheme extends StandardScheme<TimResponseBean> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TimResponseBean struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // THREAD_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.threadId = iprot.readString();
              struct.setThreadIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ERROR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.error = new TimError();
              struct.error.read(iprot);
              struct.setErrorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EXTRA_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list216 = iprot.readListBegin();
                struct.extraList = new ArrayList<TimNode>(_list216.size);
                TimNode _elem217;
                for (int _i218 = 0; _i218 < _list216.size; ++_i218)
                {
                  _elem217 = new TimNode();
                  _elem217.read(iprot);
                  struct.extraList.add(_elem217);
                }
                iprot.readListEnd();
              }
              struct.setExtraListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // EXTRA_MAP
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map219 = iprot.readMapBegin();
                struct.extraMap = new HashMap<String,String>(2*_map219.size);
                String _key220;
                String _val221;
                for (int _i222 = 0; _i222 < _map219.size; ++_i222)
                {
                  _key220 = iprot.readString();
                  _val221 = iprot.readString();
                  struct.extraMap.put(_key220, _val221);
                }
                iprot.readMapEnd();
              }
              struct.setExtraMapIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TimResponseBean struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.threadId != null) {
        if (struct.isSetThreadId()) {
          oprot.writeFieldBegin(THREAD_ID_FIELD_DESC);
          oprot.writeString(struct.threadId);
          oprot.writeFieldEnd();
        }
      }
      if (struct.error != null) {
        if (struct.isSetError()) {
          oprot.writeFieldBegin(ERROR_FIELD_DESC);
          struct.error.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.extraList != null) {
        if (struct.isSetExtraList()) {
          oprot.writeFieldBegin(EXTRA_LIST_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.extraList.size()));
            for (TimNode _iter223 : struct.extraList)
            {
              _iter223.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.extraMap != null) {
        if (struct.isSetExtraMap()) {
          oprot.writeFieldBegin(EXTRA_MAP_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.extraMap.size()));
            for (Map.Entry<String, String> _iter224 : struct.extraMap.entrySet())
            {
              oprot.writeString(_iter224.getKey());
              oprot.writeString(_iter224.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TimResponseBeanTupleSchemeFactory implements SchemeFactory {
    public TimResponseBeanTupleScheme getScheme() {
      return new TimResponseBeanTupleScheme();
    }
  }

  private static class TimResponseBeanTupleScheme extends TupleScheme<TimResponseBean> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TimResponseBean struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetThreadId()) {
        optionals.set(0);
      }
      if (struct.isSetError()) {
        optionals.set(1);
      }
      if (struct.isSetExtraList()) {
        optionals.set(2);
      }
      if (struct.isSetExtraMap()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetThreadId()) {
        oprot.writeString(struct.threadId);
      }
      if (struct.isSetError()) {
        struct.error.write(oprot);
      }
      if (struct.isSetExtraList()) {
        {
          oprot.writeI32(struct.extraList.size());
          for (TimNode _iter225 : struct.extraList)
          {
            _iter225.write(oprot);
          }
        }
      }
      if (struct.isSetExtraMap()) {
        {
          oprot.writeI32(struct.extraMap.size());
          for (Map.Entry<String, String> _iter226 : struct.extraMap.entrySet())
          {
            oprot.writeString(_iter226.getKey());
            oprot.writeString(_iter226.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TimResponseBean struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.threadId = iprot.readString();
        struct.setThreadIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.error = new TimError();
        struct.error.read(iprot);
        struct.setErrorIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list227 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.extraList = new ArrayList<TimNode>(_list227.size);
          TimNode _elem228;
          for (int _i229 = 0; _i229 < _list227.size; ++_i229)
          {
            _elem228 = new TimNode();
            _elem228.read(iprot);
            struct.extraList.add(_elem228);
          }
        }
        struct.setExtraListIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TMap _map230 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.extraMap = new HashMap<String,String>(2*_map230.size);
          String _key231;
          String _val232;
          for (int _i233 = 0; _i233 < _map230.size; ++_i233)
          {
            _key231 = iprot.readString();
            _val232 = iprot.readString();
            struct.extraMap.put(_key231, _val232);
          }
        }
        struct.setExtraMapIsSet(true);
      }
    }
  }

}
