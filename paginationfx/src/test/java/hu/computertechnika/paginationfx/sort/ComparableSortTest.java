/**
 * Copyright 2018 PaginationFX
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
 * and associated documentation files (the "Software"), to deal in the Software without 
 * restriction, including without limitation the rights to use, copy, modify, merge, publish, 
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or 
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR 
 * ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE 
 * SOFTWARE. 
*/
package hu.computertechnika.paginationfx.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Gábor Balanyi
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComparableSortTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComparableSortTest.class);

	@Test
	public void test0None() {

		List<Integer> list = Arrays.asList(3, null, 2, 1, null);
		ComparableSort<Integer> sort = new ComparableSort<>();
		list = list.stream().sorted(sort.createExpression()).collect(Collectors.toList());

		LOGGER.debug(list.toString());
		Assert.assertTrue(list.get(0) == 3 && list.get(4) == null);

	}

	@Test
	public void test1Asc() {

		List<Integer> list = Arrays.asList(3, null, 2, 1, null);
		ComparableSort<Integer> sort = new ComparableSort<>();
		sort.setSortType(SortType.ASCENDING);
		list = list.stream().sorted(sort.createExpression()).collect(Collectors.toList());

		LOGGER.debug(list.toString());
		Assert.assertTrue(list.get(0) == null && list.get(4) == 3);

	}

	@Test
	public void test2Desc() {

		List<Integer> list = Arrays.asList(3, null, 2, 1, null);
		ComparableSort<Integer> sort = new ComparableSort<>();
		sort.setSortType(SortType.DESCENDING);
		list = list.stream().sorted(sort.createExpression()).collect(Collectors.toList());

		LOGGER.debug(list.toString());
		Assert.assertTrue(list.get(4) == null && list.get(0) == 3);

	}

}
