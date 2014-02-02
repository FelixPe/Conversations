package de.gultsch.chat.xmpp;

import de.gultsch.chat.xml.Element;

public class MessagePacket extends Element {
	public static final int TYPE_CHAT = 0;

	private MessagePacket(String name) {
		super(name);
	}
	
	public MessagePacket() {
		super("message");
	}
	
	public String getTo() {
		return getAttribute("to");
	}

	public String getFrom() {
		return getAttribute("from");
	}
	
	public String getBody() {
		return this.findChild("body").getContent();
	}
	
	public void setTo(String to) {
		setAttribute("to", to);
	}
	
	public void setFrom(String from) {
		setAttribute("from",from);
	}
	
	public void setBody(String text) {
		Element body = new Element("body");
		body.setContent(text);
		this.children.add(body);
	}

	public void setType(int type) {
		switch (type) {
		case TYPE_CHAT:
			this.setAttribute("type","chat");
			break;

		default:
			this.setAttribute("type","chat");
			break;
		}
	}
}