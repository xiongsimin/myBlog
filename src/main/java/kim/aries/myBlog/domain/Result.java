package kim.aries.myBlog.domain;

import java.io.Serializable;

/**
 * 
 * @author 白羊座 封装后端返回给前端的数据
 */
public class Result implements Serializable {
	private boolean success;
	private String code;
	private String msg;
	private Object data;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(boolean success, String code, String msg, Object data) {
		super();
		this.success = success;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
