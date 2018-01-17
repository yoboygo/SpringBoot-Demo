package org.demo.websocket;

/**
 * 服务器返回给浏览器的消息
 * @author bpqqo
 *
 */
public class WiselyReponse {

	private String responseMessage;
	
	public WiselyReponse(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
