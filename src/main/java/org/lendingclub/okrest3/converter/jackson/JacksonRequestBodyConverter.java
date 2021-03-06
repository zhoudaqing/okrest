/**
 * Copyright 2017 Lending Club, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.lendingclub.okrest3.converter.jackson;

import org.lendingclub.okrest3.converter.RequestBodyConverter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public  class JacksonRequestBodyConverter extends RequestBodyConverter {

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public RequestBody convert(Object input) {

		return RequestBody.create(MediaType.parse("application/json"), JsonNode.class
				.cast(input).toString());

	}

	@Override
	public boolean supports(Object input) {
		return input instanceof JsonNode;
	}

}
