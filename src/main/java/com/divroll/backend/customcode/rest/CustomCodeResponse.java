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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author <a href="mailto:kerby@divroll.com">Kerby Martino</a>
 * @version 0-SNAPSHOT
 * @since 0-SNAPSHOT
 */
public class CustomCodeResponse {
	private final int responseStatus;
	private Map<String, ?> responseMap = null;
	private byte[] responseBody = null;
	public CustomCodeResponse(int responseCode, byte[] responseBody) {
		this.responseStatus = responseCode;
		this.responseBody = responseBody;
	}
	public CustomCodeResponse(int responseCode, Map<String, ?> responseMap) {
		this.responseStatus = responseCode;
		this.responseMap = responseMap;
	}
	public int getResponseStatus() {
		return responseStatus;
	}
	public Map<String, ?> getResponseMap() {
		return responseMap;
	}
	public byte[] getResponseBody() {
		return responseBody;
	}
}
