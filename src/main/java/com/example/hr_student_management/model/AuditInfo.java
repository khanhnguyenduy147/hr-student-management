package com.example.hr_student_management.model;

import java.time.OffsetDateTime;
import lombok.Data;

/**
 * Audit info class provides audit field for response object.
 *
 * @param <T> Source class
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
@Data
public abstract class AuditInfo<T extends AuditInfo<?>> {
    private RecordStatus recordStatus;
    private Long currNo;
    private String createBy;
    private String inputter;
    private String authoriser;
    private String coCode;
    private String departmentCode;
    private OffsetDateTime createAt;
    private OffsetDateTime updateAt;

    /**
     * Setter.
     *
     * @param recordStatus recordStatus
     * @return source object
     */
    public T setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
        return (T) this;
    }

    /**
     * Setter.
     *
     * @param currNo currNo
     * @return source object
     */
    public T setCurrNo(Long currNo) {
        this.currNo = currNo;
        return (T) this;
    }

    /**
     * Setter.
     *
     * @param createBy createBy
     * @return source object
     */
    public T setCreateBy(String createBy) {
        this.createBy = createBy;
        return (T) this;
    }

    /**
     * Setter.
     *
     * @param inputter inputter
     * @return source object
     */
    public T setInputter(String inputter) {
        this.inputter = inputter;
        return (T) this;
    }

    /**
     * Setter.
     *
     * @param authoriser authoriser
     * @return source object
     */
    public T setAuthoriser(String authoriser) {
        this.authoriser = authoriser;
        return (T) this;
    }

    /**
     * Setter.
     *
     * @param coCode coCode
     * @return source object
     */
    public T setCoCode(String coCode) {
        this.coCode = coCode;
        return (T) this;
    }

    /**
     * Setter.
     *
     * @param departmentCode departmentCode
     * @return source object
     */
    public T setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
        return (T) this;
    }

    /**
     * Setter.
     *
     * @param createAt createAt
     * @return source object
     */
    public T setCreateAt(OffsetDateTime createAt) {
        this.createAt = createAt;
        return (T) this;
    }

    /**
     * Setter.
     *
     * @param updateAt updateAt
     * @return source object
     */
    public T setUpdateAt(OffsetDateTime updateAt) {
        this.updateAt = updateAt;
        return (T) this;
    }
}
