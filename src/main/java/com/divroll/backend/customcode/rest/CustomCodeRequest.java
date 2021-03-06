/*
 * Divroll, Platform for Hosting Static Sites
 * Copyright 2018, Divroll, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.divroll.backend.customcode.rest;

import com.divroll.backend.customcode.MethodVerb;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author <a href="mailto:kerby@divroll.com">Kerby Martino</a>
 * @version 0-SNAPSHOT
 * @since 0-SNAPSHOT
 */
public class CustomCodeRequest {
	private final MethodVerb verb;
	private final String url;
	private final InputStream body;
	private final Map<String, String> params;
	private final String methodName;
	private final long counter;

	public CustomCodeRequest(MethodVerb verb,
							 String url,
							 Map<String, String> params,
							 InputStream body,
							 String methodName,
							 long counter) {
		this.verb = verb;
		this.url = url;
		this.methodName = methodName;
		this.params = params;
		this.counter = counter;
		this.body = body;
	}


	public MethodVerb getVerb() {
		return verb;
	}


	public String getUrl() {
		return url;
	}

	public Map<String, String> getParams() {
		return params;
	}


	public String getMethodName() {
		return methodName;
	}


	public long getCounter() {
		return counter;
	}


	public InputStream getBody() {
		return body;
	}

	public String getStringBody() {
		if(body != null) {
			try (Scanner scanner = new Scanner(body, "UTF-8")) {
				return scanner.useDelimiter("\\A").next();
			}
		}
		return null;
	}

}
