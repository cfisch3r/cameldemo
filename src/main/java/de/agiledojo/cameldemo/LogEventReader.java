package de.agiledojo.cameldemo;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Handler;
import org.springframework.stereotype.Service;

@Service
public class LogEventReader {

	@Handler
	public void processMessage(String message) {

	}

	public List<String> getMessages() {

		return new ArrayList<String>();
	}

}
