/**
 * Copyright 2017 Dotweblabs Web Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.divroll.backend.functions.rest;

import java.io.*;
import java.util.Map;

import com.divroll.backend.functions.MethodVerb;

/**
 *
 * @author <a href="mailto:kerby@dotweblabs.com">Kerby Martino</a>
 * @version 1.0
 * @since 1.0
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
			return slurp(body, 1024*1024*10); // TODO
		}
		return null;
	}

	public static String slurp(final InputStream is, final int bufferSize) {
		final char[] buffer = new char[bufferSize];
		final StringBuilder out = new StringBuilder();
		try (Reader in = new InputStreamReader(is, "UTF-8")) {
			for (;;) {
				int rsz = in.read(buffer, 0, buffer.length);
				if (rsz < 0)
					break;
				out.append(buffer, 0, rsz);
			}
		}
		catch (UnsupportedEncodingException ex) {
		}
		catch (IOException ex) {
		}
		return out.toString();
	}

}
