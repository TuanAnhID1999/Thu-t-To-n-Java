package week9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedArraySimpleTable <Key extends Comparable<Key>, Value> implements OrderedSimpleTable<Key, Value>{

	private Key[] keys;
	private Value[] values;
	private int n;
	public OrderedArraySimpleTable() {
		// TODO Auto-generated constructor stub
		keys = (Key[]) new Comparable[100];
		values = (Value[]) new Object[100];
		n = 0;
	}
	@Override
	public void put(Key key, Value value) {
		// TODO Auto-generated method stub
		int r = rank(key);
		if(keys[r] == key)
			values[r] = value;
		else
			n++;
			for (int i = n; i > r; i--) {
				keys[i] = keys[i-1];
				values[i] = values[i-1];
			}
			keys[r] = key;
			values[r] = value;
	}

	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		int r = rank(key);
		if(keys[r] == key)
			return values[r];
		return null;
	}

	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub
		int r = rank(key);
		if(keys[r] == key)
			values[r] = null;
	}

	@Override
	public boolean constains(Key key) {
		// TODO Auto-generated method stub
		int r = rank(key);
		if(keys[r]==key)
			return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public Iterable<Key> keys() {
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				return new Iterator<Key>() {

					private int position;

					@Override
					public boolean hasNext() {
						return (position < n);
					}

					@Override
					public Key next() {
						if (!hasNext())
							throw new NoSuchElementException();
						return keys[position++];
					}
				};
			}
		};
	}

	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return keys[0];
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return keys[n-1];
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		int r = rank(key);
		if(keys[r] == key)
			if(r>0)
				return keys[r-1];
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		int r = rank(key);
		if(keys[r] == key) {
			if(keys[r] == key)
				return keys[r+1];
		}
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		int u = 0;
		int v = n -1;
		while(u<=v) {
			int m = u+(v-u)/2;
			if(keys[m].compareTo(key)>0)
				v = m-1;
			else if(keys[m].compareTo(key)<0)
				u = m+1;
			else
				return m;
		}
		return u;
	}

	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		return keys[k];
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub
		values[0] = null;
	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub
		values[n-1] = null;
	}

	@Override
	public int size(Key u, Key v) {
		// TODO Auto-generated method stub
		return rank(v)-rank(u);
	}

	@Override
	public Iterable<Key> keys(Key u, Key v) {
		// TODO Auto-generated method stub
		return new Iterable<Key>() {

			@Override
			public Iterator<Key> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Key>() {
					private int position;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return (position>rank(u)) && (position<rank(v));
					}

					@Override
					public Key next() {
						// TODO Auto-generated method stub
						if(!hasNext()) {
							throw new NoSuchElementException();
						}
						return keys[position++];
					}
				};
			}
			
		};
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(keys[i] +" - ");
			sb.append(values[i]+ " - ");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		OrderedSimpleTable<String, Integer> st = new OrderedArraySimpleTable<String, Integer>();
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		st.put("a", 5);
		st.put("b", 3);
		st.put("c", 4);
		System.out.println(st);
		System.out.println(st.size());
	}

}
