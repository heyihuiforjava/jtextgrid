/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
 */

package com.github.errantlinguist.jtextgrid;

/**
 * A single entry in the TextGrid file, representing either an interval or a
 * point on a tier.
 * 
 * @author Todd Shore
 * @version 2012-01-16
 * @since 2011-04-15
 * 
 * @param <D>
 *            The object type representing the entry data.
 */
public final class Entry<D> extends TimeSeriesData<Entry<D>> {

	/**
	 * The annotation data the entry represents.
	 */
	protected final D data;

	/**
	 * The hash code for final members.
	 */
	private final int precachedHashCode;

	/**
	 * The {@link Tier} representing the tier the entry is on.
	 */
	private final Tier<D> tier;

	/**
	 * @param tier
	 *            The {@link Tier} object representing the textGridTier the
	 *            entry is on.
	 * @param id
	 *            The ID of the entry.
	 * @param startTime
	 *            The start time of the entry.
	 * @param endTime
	 *            The end time of the entry.
	 * @param data
	 *            The annotation data the entry represents.
	 */
	Entry(final Tier<D> tier, final double startTime, final double endTime,
			final D data) {
		super(startTime, endTime);
		this.tier = tier;
		this.data = data;

		this.precachedHashCode = calculateHashCode();
	}

	/**
	 * Pre-caches the hash code for final members.
	 * 
	 * @return The hash code for final members.
	 */
	private int calculateHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (data == null ? 0 : data.hashCode());
		// If the tier is not null, combine the hash of the entry's ID with the
		// hash in order to differentiate entries which are equal in all ways
		// except for the tier they are on.
		if (tier != null) {
			final Integer id = getID();
			result = prime * result + (id == null ? 0 : id.hashCode());
		} else {
			result = prime * result;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TimeSeriesData#deepCompareTo(TimeSeriesData)
	 */
	@Override
	protected int deepCompareTo(final Entry<D> arg0) {
		int comp = 0;

		// Compare textGridTier IDs
		final int tid1 = tier.getID();
		final int tid2 = arg0.tier.getID();

		if (tid1 < tid2) {
			comp = -1;
		} else if (tid1 < tid2) {
			comp = 1;
		} else {

			// Try to compare the entry IDs
			// if (textGridTier != null) {
			//
			// if (arg0.textGridTier != null) {
			// final int id1 = getID();
			// final int id2 = arg0.getID();
			// if (id1 < id2) {
			// comp = -1;
			// } else if (id1 < id2) {
			// comp = 1;
			// }
			//
			// } else {
			// return -1;
			// }
			//
			// } else if (arg0.textGridTier != null) {
			// return 1;
			// }

		}

		return comp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Entry<?>)) {
			return false;
		}
		final Entry<?> other = (Entry<?>) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}

		return true;
	}

	/**
	 * @return the data
	 */
	public D getData() {
		return data;
	}

	/**
	 * @return The ID of the entry.
	 */
	public Integer getID() {
		return tier.getID(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return precachedHashCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Entry[startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
}
