CREATE TABLE BUSSINESSFUNCTION (
                          id   VARCHAR2(50) NOT NULL,
                          name VARCHAR2(100) NOT NULL
                          CONSTRAINT pk_bussinessfunction PRIMARY KEY (id) -- Khóa chính
);

CREATE TABLE CLASS_DESCRIPTION (
                                  id              VARCHAR2(100) NOT NULL,        -- Trường ID, không cho phép null
                                  key_field       VARCHAR2(100),                 -- Trường key (thêm _1 vào tên gốc)
                                  name            VARCHAR2(255),                 -- Tên trường
                                  inputType       VARCHAR2(50),                  -- Kiểu nhập (text, number, select, ...)
                                  type            VARCHAR2(50),                  -- Loại (single/multi)
                                  required        NUMBER(1),                       -- Trường bắt buộc (Y/N, true/false)
                                  minLength       NUMBER,                        -- Độ dài tối thiểu
                                  maxLength       NUMBER,                        -- Độ dài tối đa
                                  parentId        VARCHAR2(100),                 -- Trường cha nếu type = multi
                                  api             VARCHAR2(255),                 -- API lấy dữ liệu nếu inputType = select/multi-select
                                  apiLabel        VARCHAR2(100),                 -- Tên trường trả về từ API để làm label
                                  apiValue        VARCHAR2(100),                 -- Tên trường trả về từ API để làm value
                                  data            CLOB,                          -- JSON data chứa các giá trị label/value
                                  disabled        NUMBER(1),                       -- Trường có bị vô hiệu hóa không (Y/N)
                                  defaultValue    VARCHAR2(255),                 -- Giá trị mặc định
                                  CONSTRAINT pk_classdescription PRIMARY KEY (id) -- Khóa chính
);
