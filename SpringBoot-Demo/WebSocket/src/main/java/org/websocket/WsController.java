package org.websocket;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WiselyReponse say(WiselyMessage message) throws InterruptedException{
		Thread.sleep(3000);
		return new WiselyReponse("Welcome " + message.getName() + "!");
	}
	
	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg) {
		if(principal.getName().equals("wyf")) {
			messagingTemplate.convertAndSendToUser("wisely", "/queue/notifications", principal.getName() + "-send:" + msg);
		}else {
			messagingTemplate.convertAndSendToUser("wyf", "/queue/notifications", principal.getName() + "-send:" + msg);
		}
	}
}
