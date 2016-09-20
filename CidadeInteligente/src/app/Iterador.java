package app;

public interface Iterador<T>
	extends java.util.Iterator<T>
{
	void insert(T valor);
	void append(T valor);
}
