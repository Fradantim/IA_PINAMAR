package com.ia.tmi.iatmi.transformers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public abstract class Transformer<T,U> {
	
	public abstract U transform(T element);
	
	public List<U> transform(List<? extends T> elements) {
		return elements.stream().map(m -> transform(m)).collect(Collectors.toList());
	}
}