/*
 * Copyright 2002-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.http.client.reactive;

import java.util.concurrent.atomic.AtomicBoolean;

import reactor.core.publisher.Flux;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;

/**
 * Base class for {@link ClientHttpResponse} implementations.
 *
 * @author Arjen Poutsma
 * @since 5.3.32
 */
public abstract class AbstractClientHttpResponse implements ClientHttpResponse {

	private final int statusCode;

	private final HttpHeaders headers;

	private final MultiValueMap<String, ResponseCookie> cookies;

	private final Flux<DataBuffer> body;



	protected AbstractClientHttpResponse(int statusCode, HttpHeaders headers,
			MultiValueMap<String, ResponseCookie> cookies, Flux<DataBuffer> body) {

		Assert.notNull(headers, "Headers must not be null");
		Assert.notNull(body, "Body must not be null");

		this.statusCode = statusCode;
		this.headers = headers;
		this.cookies = cookies;
		this.body = singleSubscription(body);
	}

	private static Flux<DataBuffer> singleSubscription(Flux<DataBuffer> body) {
		AtomicBoolean subscribed = new AtomicBoolean();
		return body.doOnSubscribe(s -> {
			if (!subscribed.compareAndSet(false, true)) {
				throw new IllegalStateException("The client response body can only be consumed once");
			}
		});
	}


	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.valueOf(this.statusCode);
	}

	@Override
	public int getRawStatusCode() {
		return this.statusCode;
	}

	@Override
	public HttpHeaders getHeaders() {
		return this.headers;
	}

	@Override
	public MultiValueMap<String, ResponseCookie> getCookies() {
		return this.cookies;
	}

	@Override
	public Flux<DataBuffer> getBody() {
		return this.body;
	}
}
