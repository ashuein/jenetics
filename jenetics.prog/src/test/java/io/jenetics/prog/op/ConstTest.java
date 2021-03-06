/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmail.com)
 */
package io.jenetics.prog.op;

import nl.jqno.equalsverifier.EqualsVerifier;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.jenetics.util.IO;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 */
public class ConstTest {

	@Test
	public void equalsVerifier() {
		EqualsVerifier.forClass(Const.class)
			.withIgnoredFields("_name")
			.verify();
	}

	@Test
	public void serialize() throws IOException {
		final Const<Integer> object = Const.of("some name", new Random().nextInt());
		final byte[] data = IO.object.toByteArray(object);
		Assert.assertEquals(IO.object.fromByteArray(data), object);
	}

}
