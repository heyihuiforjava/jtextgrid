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
package com.github.errantlinguist.tree;

/**
 * An interface for {@link Child} classes which for which the value supplied by
 * {@link #getParent()} can be (re-)set.
 * 
 * @param <P>
 *            The type of the parent object.
 * 
 * @since 2014-02-06
 * @version 2014-02-06
 * @author <a href="mailto:errantlinguist+github@gmail.com">Todd Shore</a>
 */
public interface MutableChild<P> extends Child<P> {

	/**
	 * @param parent
	 *            The parent of this child object.
	 */
	void setParent(P parent);

}
