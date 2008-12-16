/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Common Public License 1.0 (http://opensource.org/licenses/cpl.php)
 *   which can be found in the file CPL.TXT at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

/* rich Dec 16, 2008 */

package clojure.lang;

import java.util.Comparator;

public abstract class AFunction extends AFn implements Comparator, Fn{

public AFunction(IPersistentMap meta){
	super(meta);
}

public AFunction(){
	super();
}

public int compare(Object o1, Object o2){
	try
		{
		Object o = invoke(o1, o2);

		if(o instanceof Boolean)
			{
			if(RT.booleanCast(o))
				return -1;
			return RT.booleanCast(invoke(o2,o1))? 1 : 0;
			}

		Number n = (Number) o;
		return n.intValue();
		}
	catch(Exception e)
		{
		throw new RuntimeException(e);
		}
}
}
