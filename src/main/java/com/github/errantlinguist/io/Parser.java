/*
 * 	Copyright 2011--2014 Todd Shore
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

/**
 * A parser which parses input into a given type.
 * 
 * @param <I>
 *            The data type to be parsed.
 * @param <O>
 *            The object type representing the input data.
 * 
 * @since 2011-07-06
 * @version 2014-02-06
 * @author <a href="mailto:errantlinguist+github@gmail.com">Todd Shore</a>
 * 
 */
public interface Parser<I, O> {

	/**
	 * Parses file data and returns a data structure representing its denoted
	 * information.
	 * 
	 * @param input
	 *            Data to be parsed.
	 * @return A new object of the generic type representing the input data.
	 * @throws ParseException
	 *             If a parse error occurs.
	 */
	public O parse(final I input) throws ParseException;

}