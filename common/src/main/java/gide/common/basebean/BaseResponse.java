package gide.common.basebean;

import java.io.Serializable;

/**
 * Created by zhaofuqi on 2017/9/19.
 */

public class BaseResponse<T> implements Serializable {
    public String code;
    public String msg;
    public T data;

    public boolean success() {
        return "1".equals(code);
    }

    @Override
    public String toString() {
        return "BaseRespose{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
