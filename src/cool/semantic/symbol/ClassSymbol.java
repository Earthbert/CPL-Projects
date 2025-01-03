package cool.semantic.symbol;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import cool.semantic.scope.Scope;
import cool.utils.Utils;

public class ClassSymbol extends Symbol implements Scope<IdSymbol> {

	protected ClassSymbol parent;

	private Integer initTempLocations = 0;

	private final Map<String, IdSymbol> fields = new LinkedHashMap<>();
	private final Map<String, MethodSymbol> methods = new LinkedHashMap<>();

	public ClassSymbol() {
		super("");
	}

	public ClassSymbol(final String name) {
		super(name);
		this.fields.put(Utils.SELF, new IdSymbol(Utils.SELF, SymbolTable.getSelfType(), IDSymbolType.FORMAL));
	}

	public ClassSymbol(final String name, final ClassSymbol parent) {
		this(name);
		this.parent = parent;
	}

	public void setParent(final ClassSymbol parent) {
		this.parent = parent;
	}

	public ClassSymbol getParent() {
		return this.parent;
	}

	public boolean hasParent(final ClassSymbol parent) {
		if (this.parent == null)
			return false;

		if (this.parent.equals(parent))
			return true;

		return this.parent.hasParent(parent);
	}

	public boolean isSuperClassOf(final ClassSymbol child) {
		if (this.equals(child))
			return true;

		if (child instanceof final SelfTypeSymbol selfType)
			return this.isSuperClassOf(selfType.getClassSymbol());

		return child.hasParent(this);
	}

	public ClassSymbol mostCommonAncestor(final ClassSymbol other) {
		if (this.isSuperClassOf(other))
			return this;

		return this.parent.mostCommonAncestor(other);
	}

	@Override
	public boolean add(final IdSymbol sym) {
		final Optional<IdSymbol> symbol = this.lookup(sym.getName());
		return symbol.isEmpty() && this.fields.putIfAbsent(sym.getName(), sym) == null;
	}

	public boolean addMethod(final MethodSymbol method) {
		final Optional<MethodSymbol> symbol = this.lookupCurrentMethod(method.getName());
		return symbol.isEmpty() && this.methods.putIfAbsent(method.getName(), method) == null;
	}

	@Override
	public Optional<IdSymbol> lookup(final String name) {
		final IdSymbol symbol = this.fields.get(name);

		if (symbol != null)
			return Optional.of(symbol);

		if (this.parent != null)
			return this.parent.lookup(name);

		return Optional.empty();
	}

	@Override
	public Optional<IdSymbol> lookupCurrent(final String name) {
		return Optional.ofNullable(this.fields.get(name));
	}

	public Optional<MethodSymbol> lookupMethod(final String name) {
		final MethodSymbol method = this.methods.get(name);

		if (method != null)
			return Optional.of(method);

		if (this.parent != null)
			return this.parent.lookupMethod(name);

		return Optional.empty();
	}

	public Optional<MethodSymbol> lookupCurrentMethod(final String name) {
		return Optional.ofNullable(this.methods.get(name));
	}

	public List<IdSymbol> getFields() {
		final List<IdSymbol> result = this.parent == null ? new ArrayList<>() : this.parent.getFields();
		result.addAll(this.fields.values().stream().filter(f -> !Utils.SELF.equals(f.getName())).toList());
		return result;
	}

	public List<MethodSymbol> getDispatchTable() {
		final List<MethodSymbol> dispatchTable = this.parent == null ? new ArrayList<>()
				: this.parent.getDispatchTable();

		for (final var method : this.methods.values()) {
			if (dispatchTable.contains(method)) {
				dispatchTable.set(dispatchTable.indexOf(method), method);
			} else {
				dispatchTable.add(method);
			}
		}

		return dispatchTable;
	}

	public Integer computeFieldsOffsets() {
		Integer offset = this.parent == null ? 0 : this.parent.computeFieldsOffsets();

		for (final var field : this.fields.values()) {
			if (Utils.SELF.equals(field.getName()))
				continue;
			field.setOffset(offset);
			offset += 4;
		}

		return offset;
	}

	public Integer getInitTempLocations() {
		return this.initTempLocations;
	}

	public void setInitTempLocations(final Integer tempLocalCount) {
		this.initTempLocations = tempLocalCount;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof final ClassSymbol other) {
			return this.getName().equals(other.getName());
		}
		return false;
	}

	public String getClassName() {
		return this.getName();
	}
}
