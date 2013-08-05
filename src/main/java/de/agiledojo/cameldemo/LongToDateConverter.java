package de.agiledojo.cameldemo;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class LongToDateConverter implements Converter<Long, Date> {

	@Override
	public Date convert(Long source) {
		return new Date(source);
	}

}
