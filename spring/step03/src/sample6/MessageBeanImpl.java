package sample6;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean{

	private String name;
	private String phone;
	private Outputter outputter;
	
	public MessageBeanImpl(String name) {
		this.name = name;
	}
	
	@Override
	public void helloCall() {
		String message = name + " : "+phone;
		System.out.println(message);
		
		try {
			outputter.output(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Outputter getOutputter() {
		return outputter;
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}

	
	
	
}
