package panama.foreign;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.util.Arrays;

public class ForeignFunctionMemoryAPI {
	public static void main(String[] args) throws Throwable {
		Linker linker = Linker.nativeLinker();
		SymbolLookup stdlib = linker.defaultLookup();
		MethodHandle strlen = linker.downcallHandle(
				stdlib.lookup("strlen").get(),
				FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS));
		SegmentAllocator allocator = SegmentAllocator.implicitAllocator();
		MemorySegment cString = allocator.allocateUtf8String("Hello World");
		Object len = strlen.invoke(cString);
		System.out.println(len);
	}
}
