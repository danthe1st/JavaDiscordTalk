package amber.sealed_classes;

public sealed class SealedClass permits FinalSubclass, NonSealedSubclass, SealedSubclass {
	//could be an interface as well
}
