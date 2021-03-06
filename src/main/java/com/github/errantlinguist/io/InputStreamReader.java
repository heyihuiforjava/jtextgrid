/*
 * 	Copyright 2014 Todd Shore
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.github.errantlinguist.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * An interface for classes which which read a {@link FileInputStream}, and
 * returns an object representing the data therein. Unfortunately, the most descriptive name for this interface clashes with that of {@link java.io.InputStreamReader a class in the Java standard library}; The two are related but only in that they both read in data from {@link InputStream} objects.
 * 
 * @author <a href="mailto:errantlinguist+github@gmail.com">Todd Shore</a>
 * @version 2014-02-11
 * @since 2011-07-11
 * 
 * @param <O>
 *            The object type representing the file data.
 * @param <E>
 *            A {@link Throwable} type thrown by the non-abstract derived class.
 * 
 */
public interface InputStreamReader<O, E extends Throwable> {

	/**
	 * Reads a file and returns the data contained therein as a new object.
	 * 
	 * @param input
	 *            The {@link FileInputStream} to be read.
	 * @return An object representing the input file.
	 * @throws IOException
	 *             If the input {@code FileInputStream} object does not refer to
	 *             a valid file or another I/O error occurs.
	 * @throws E
	 *             If there is an  otherwise-unchecked instance of {@link Throwable} thrown from a
	 *             subclass.
	 */
	O read(final InputStream input) throws IOException, E;

}
