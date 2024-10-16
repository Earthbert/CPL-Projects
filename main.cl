-- Sorry for the long file, but it's the only way to make it work with the VSCode extension

class Main inherits Utils {
    -- List of lists of objects
    lists : List <- new List.initEmpty();

    -- Current list of objects being loaded
    currentList : List <- new List.initEmpty();

    --- Main loop
    looping : Bool <- true;

    -- Loading mode
    loading : Bool <- true;

    -- String to be processed
    somestr : String;

    main() : Object {
        while looping loop {
            somestr <- in_string();
            let tokens : List <- separateInTokens(somestr) in
                if loading then
                    load(tokens)
                else
                    processCommand(tokens)
                fi;
        } pool
    };
    
    load(tokens : List) : Object {
        if castToString(tokens.get(0)) = "END" then
            if tokens.length() = 1 then {
                loading <- false;
                lists.add(currentList);
                currentList <- new List.initEmpty();
            }
            else
                abortWithMessage("END: Invalid number of arguments")
            fi
        else
            currentList.add(createObjectFromTokens(tokens))
        fi
    };

    processCommand(tokens : List) : Object {

        if castToString(tokens.get(0)) = "exit" then
            if tokens.length() = 1 then
                looping <- false
            else
                abortWithMessage("exit: Invalid number of arguments")
            fi
        else

        if castToString(tokens.get(0)) = "load" then
            if tokens.length() = 1 then
                loading <- true
            else
                abortWithMessage("load: Invalid number of arguments")
            fi
        else

        if castToString(tokens.get(0)) = "print" then
            if tokens.length() = 2 then
                let i : Int <- new A2I.a2i(castToString(tokens.get(1))) in
                    if i < 1 then
                        abortWithMessage("print: Invalid index")
                    else
                        if lists.length() < i then
                            abortWithMessage("print: Index out of bounds")
                        else
                            out_string(new ToString.getString(lists.get(i - 1)))
                        fi
                    fi
            else
                out_string(lists.toStringWithIndexs())
            fi
        else

        if castToString(tokens.get(0)) = "merge" then
            if tokens.length() = 3 then
                let i1 : Int <- new A2I.a2i(castToString(tokens.get(1))),
                    i2 : Int <- new A2I.a2i(castToString(tokens.get(2))) in
                    if i1 < 1 then
                        abortWithMessage("print: Invalid index")
                    else
                    if i2 < 1 then
                        abortWithMessage("print: Invalid index")
                    else
                    if lists.length() < i1 then
                        abortWithMessage("print: Index out of bounds")
                    else
                    if lists.length() < i2 then
                        abortWithMessage("print: Index out of bounds")
                    else
                        let l1 : List <- castToList(lists.get(i1 - 1)),
                            l2 : List <- castToList(lists.get(i2 - 1)) in {
                                lists <- lists.remove(l1);
                                lists <- lists.remove(l2);
                                l1 <- l1.merge(l2);
                                lists.add(l1);
                            }
                    fi fi fi fi
            else
                abortWithMessage("merge: Invalid number of arguments")
            fi
        else

        if castToString(tokens.get(0)) = "sortBy" then
            if tokens.length() = 4 then
                let i : Int <- new A2I.a2i(castToString(tokens.get(1))),
                    comparator : Comparator <- getComparatorFromString(castToString(tokens.get(2))),
                    order : Bool <- getSortOrderFromString(castToString(tokens.get(3))) in
                    if i < 1 then
                        abortWithMessage("sortBy: Invalid index")
                    else
                    if lists.length() < i then
                        abortWithMessage("sortBy: Index out of bounds")
                    else
                        let l : List <- castToList(lists.get(i - 1)) in {
                            l <- l.sort(comparator.init(order));
                        }
                    fi fi
            else
                abortWithMessage("sortBy: Invalid number of arguments")
            fi
        else

        if castToString(tokens.get(0)) = "filterBy" then
            if tokens.length() = 3 then
                let i : Int <- new A2I.a2i(castToString(tokens.get(1))),
                    filter : Filter <- getFilterFromString(castToString(tokens.get(2))) in
                    if i < 1 then
                        abortWithMessage("filterBy: Invalid index")
                    else
                    if lists.length() < i then
                        abortWithMessage("filterBy: Index out of bounds")
                    else
                        let l : List <- castToList(lists.get(i - 1)) in {
                            lists.replace(l, l.filter(filter));
                        }
                    fi fi
            else
                abortWithMessage("filterBy: Invalid number of arguments")
            fi
        else
            abortWithMessage("Invalid command")
        fi fi fi fi fi fi
    };
};

-- ########################################## LIST ##########################################

class List inherits IO {
    head : Object;
    tail : List;

    initEmpty() : List {{
        tail <- new List;
        self;
    }};

    single(h : Object) : List {{
        head <- h;
        tail <- new List;
        self;
    }};

    init(h : Object, t : List) : List {{
        head <- h;
        tail <- t;
        self;
    }};

    head() : Object {
        head
    };

    setHead(h : Object) : Object {
        head <- h
    };

    tail() : List {
        tail
    };

    add(o : Object) : List {
        if isvoid head then {
            head <- o;
            tail <- new List.initEmpty();
            self;
        }
        else
            tail.add(o)
        fi
    };

    addToIndex(o : Object, i : Int) : List {
        if i = 0 then {
            tail <- new List.init(head, tail);
            head <- o;
            self;
        }
        else
            if isvoid head then {
                new Utils.abortWithMessage("Index out of bounds");
                self;
            }
            else {
                tail <- tail.addToIndex(o, i - 1);
                self;
            }
            fi
        fi
    };

    remove(o : Object) : List {
        if isvoid head then {
            new Utils.abortWithMessage("Cannot find object to remove");
            self;
        }
        else 
        if head = o then {
            head <- tail.head();
            tail <- tail.tail();
            self;
        }
        else {
            tail <- tail.remove(o);
            self;
        }
        fi fi
    };

    replace(o1 : Object, o2 : Object) : List {
        if isvoid head then {
            new Utils.abortWithMessage("Cannot find object to replace");
            self;
        }
        else 
        if head = o1 then {
            head <- o2;
            self;
        }
        else {
            tail.replace(o1, o2);
            self;
        }
        fi fi
    };

    get(i : Int) : Object {
        if isvoid head then
            new Utils.abortWithMessage("Index out of bounds")
        else
            if i = 0 then head else tail.get(i - 1) fi
        fi
    };

    empty() : Bool {
        isvoid head
    };

    length() : Int {
        if empty() then 0 else 1 + tail.length() fi
    };

    toStringWithIndexs() : String {
        private_toStringWithIndexs(1)
    };

    private_toStringWithIndexs(index : Int) : String {
        if empty()
        then ""
        else (new A2I.i2a(index)).concat(": ").concat(new ToString.getString(head))
                                 .concat(tail.private_toStringWithIndexs(index + 1))
        fi
    };

    toString() : String {
        if empty() then "[  ]\n" else
        "[ ".concat(private_toString())
        fi
    };

    private_toString() : String {
        if tail.empty()
        then (new ToString.getString(head)).concat(" ]\n")
        else (new ToString.getString(head)).concat(", ").concat(tail.private_toString())
        fi
    };

    merge(l : List) : List {
        if empty() then l else {tail <- tail.merge(l); self;} fi
    };

    sort(c : Comparator) : List {
        let current : List <- self, index : List, min : List, temp : Object in {
            while
                current.empty() = false
            loop {
                index <- current.tail();
                min <- current;

                while
                    index.empty() = false
                loop {
                    if c.compareTo(index.head(), min.head()) < 0 then
                        min <- index
                    else
                        min
                    fi;
                    index <- index.tail();
                }
                pool;

                temp <- current.head();
                current.setHead(min.head());
                min.setHead(temp);

                current <- current.tail();
            }
            pool;
            self;
        }
    };

    filter (f : Filter) : List {
        if empty() then
            self
        else {
            tail <- tail.filter(f);
            if f.apply(head) then
                self
            else
                tail
            fi;
        }
        fi
    };

    forEach(f : Consumer) : Object {
        if empty() then
            self
        else {
            f.apply(head);
            tail.forEach(f);
        }
        fi
    };
};

-- ########################################## THINGS ##########################################

(*******************************
 *** Classes Product-related ***
 *******************************)
 class Product {
    name : String;
    model : String;
    price : Int;

    initFromTokens(tokens : List) : SELF_TYPE {{
        let utils : Utils <- new Utils in {
            name <- utils.castToString(tokens.get(1));
            model <- utils.castToString(tokens.get(2));
            price <- new A2I.a2i(utils.castToString(tokens.get(3)));
        };
        self;
    }};

    init(n : String, m: String, p : Int) : SELF_TYPE {{
        name <- n;
        model <- m;
        price <- p;
        self;
    }};

    getprice() : Int{ price * 119 / 100 };

    toString() : String {
        type_name().concat("(").concat(name)
                   .concat(";").concat(model).concat(")")
    };
};

class Edible inherits Product {
    -- VAT tax is lower for foods
    getprice() : Int { price * 109 / 100 };
};

class Soda inherits Edible {
    -- sugar tax is 20 bani
    getprice() : Int {price * 109 / 100 + 20};
};

class Coffee inherits Edible {
    -- this is technically poison for ants
    getprice() : Int {price * 119 / 100};
};

class Laptop inherits Product {
    -- operating system cost included
    getprice() : Int {price * 119 / 100 + 499};
};

class Router inherits Product {};

(****************************
 *** Classes Rank-related ***
 ****************************)
class Rank {
    name : String;

    initFromTokens(tokens : List) : SELF_TYPE {{
        let utils : Utils <- new Utils in {
            name <- utils.castToString(tokens.get(1));
        };
        self;
    }};

    init(n : String) : SELF_TYPE {{
        name <- n;
        self;
    }};

    toString() : String {
        type_name().concat("(").concat(name).concat(")")
    };
};

class Private inherits Rank {};

class Corporal inherits Private {};

class Sergent inherits Corporal {};

class Officer inherits Sergent {};

-- ########################################## FUNCTIONALS ##########################################

(* Think of these as abstract classes *)


class Filter {
    apply(o : Object) : Bool {true};
};

class ProductFilter inherits Filter {
    apply(o : Object) : Bool {
        case o of
            p : Product => true;
            o : Object => false;
        esac
    };
};

class RankFilter inherits Filter {
    apply(o : Object) : Bool {{
        case o of
            r : Rank => true;
            o : Object => false;
        esac;
    }};
};

class SamePriceFilter inherits Filter {
    apply(o : Object) : Bool {
        case o of
            p : Product => p.getprice() = p@Product.getprice();
            o : Object => false;
        esac
    };
};

class Consumer {
    apply(o : Object) : Object {self};
};

class Comparator {
    ascending : Bool;

    init(asc : Bool) : SELF_TYPE {{
        ascending <- asc;
        self;
    }};

    compareTo(o1 : Object, o2 : Object):Int {0};
};

class IntComparator inherits Comparator {
    compareTo(o1 : Object, o2 : Object) : Int {
        let i1 : Int <- case o1 of
            i : Int => i;
            o : Object => {new Utils.abortWithMessage("Invalid object type ".concat(o.type_name()). concat(" expected Int")); 0;};
        esac in
        let i2 : Int <- case o2 of
            i : Int => i;
            o : Object => {new Utils.abortWithMessage("Invalid object type ".concat(o.type_name()). concat(" expected Int")); 0;};
        esac in
        if ascending then i1 - i2 else i2 - i1 fi
    };
};

class StringComparator inherits Comparator {
    compareTo(o1 : Object, o2 : Object) : Int {
        let s1 : String <- case o1 of
            s : String => s;
            o : Object => {new Utils.abortWithMessage("Invalid object type ".concat(o.type_name()). concat(" expected String")); "";};
        esac in
        let s2 : String <- case o2 of
            s : String => s;
            o : Object => {new Utils.abortWithMessage("Invalid object type ".concat(o.type_name()). concat(" expected String")); "";};
        esac in {
            if (if ascending then s1 < s2 else s2 < s1 fi) then ~1 else 1 fi;
        }
    };
};

class RankComparator inherits Comparator {
    compareTo(o1 : Object, o2 : Object) : Int {
        let r1 : Rank <- case o1 of
            r : Rank => r;
            o : Object => {new Utils.abortWithMessage("Invalid object type ".concat(o.type_name()). concat(" expected Rank")); new Rank.init("Invalid");};
        esac in
        let r2 : Rank <- case o2 of
            r : Rank => r;
            o : Object => {new Utils.abortWithMessage("Invalid object type ".concat(o.type_name()). concat(" expected Rank")); new Rank.init("Invalid");};
        esac in
            let r1Value : Int <- case r1 of
                p : Private => 1;
                c : Corporal => 2;
                s : Sergent => 3;
                o : Officer => 4;
                r : Rank => 0;
            esac in {
            let r2Value : Int <- case r2 of
                p : Private => 1;
                c : Corporal => 2;
                s : Sergent => 3;
                o : Officer => 4;
                r : Rank => 0;
            esac in {
                if ascending then r1Value - r2Value else r2Value - r1Value fi;
            };
            }
    };
};

class ProductComparator inherits Comparator {
    compareTo(o1 : Object, o2 : Object) : Int {
        let p1 : Product <- case o1 of
            p : Product => p;
            o : Object => {new Utils.abortWithMessage("Invalid object type ".concat(o.type_name()). concat(" expected Product")); new Product.init("Invalid", "Invalid", 0);};
        esac in
        let p2 : Product <- case o2 of
            p : Product => p;
            o : Object => {new Utils.abortWithMessage("Invalid object type ".concat(o.type_name()). concat(" expected Product")); new Product.init("Invalid", "Invalid", 0);};
        esac in {
            if ascending then p1.getprice() - p2.getprice() else p2.getprice() - p1.getprice() fi;
        }
    };
};

-- ########################################## UTILS ##########################################

class Utils inherits IO {

    castToString(object : Object) : String {
        case object of
            string : String => string;
            object : Object => abortWithMessage( "Dynamic type is not String, it is".concat(object.type_name()));
        esac
    };

    castToList(object : Object) : List {
        case object of
            list : List => list;
            object : Object => {abortWithMessage( "Dynamic type is not List, it is ".concat(object.type_name())); new List.initEmpty();};
        esac
    };

    separateInTokens(s : String) : List {
        let tokens : List <- new List.initEmpty() in {
            let i : Int <- 0 in {
                while i < s.length() loop {
                    --- Skip whitespaces
                    let j : Int <- i, l : Int <- 0 in {
                        while j < s.length() loop {
                            if s.substr(j, 1) = " " then
                                l <- l + 1
                            else
                                j <- s.length()
                            fi;
                            j <- j + 1;
                        } pool;
                        i <- i + l;
                    };

                    --- Get the token
                    let j : Int <- i, l : Int <- 0 in {
                        while j < s.length() loop {
                            if s.substr(j, 1) = " " then
                                j <- s.length()
                            else
                                l <- l + 1
                            fi;
                            j <- j + 1;
                        } pool;
                        tokens.add(s.substr(i, l));
                        i <- i + l;
                    };
                } pool;
            };
            tokens;
        }
    };

    createObjectFromTokens(tokens : List) : Object {
        let s : String <- case tokens.get(0) of
            s : String => s;
            o : Object => abortWithMessage("Invalid object type");
        esac in
            if s = "String" then
                castToString(tokens.get(1))
            else if s = "Int" then
                new A2I.a2i(castToString(tokens.get(1)))
            else if s = "Bool" then
                getBoolFromString(castToString(tokens.get(1)))
            else if s = "IO" then
                new IO
            else if s = "Object" then
                new Object
            else if s = "Soda" then
                new Soda.initFromTokens(tokens)
            else if s = "Coffee" then
                new Coffee.initFromTokens(tokens)
            else if s = "Laptop" then
                new Laptop.initFromTokens(tokens)
            else if s = "Router" then
                new Router.initFromTokens(tokens)
            else if s = "Private" then
                new Private.initFromTokens(tokens)
            else if s = "Corporal" then
                new Corporal.initFromTokens(tokens)
            else if s = "Sergent" then
                new Sergent.initFromTokens(tokens)
            else if s = "Officer" then
                new Officer.initFromTokens(tokens)
            else
                abortWithMessage("Invalid object type")
            fi fi fi fi fi fi fi fi fi fi fi fi fi
    };

    getBoolFromString(s : String) : Bool {
        if s = "true" then true else
        if s = "false" then false else
            { abortWithMessage("Invalid boolean value"); false; }
        fi fi
    };

    getFilterFromString(s : String) : Filter {
        if s = "ProductFilter" then
            new ProductFilter
        else if s = "RankFilter" then
            new RankFilter
        else if s = "SamePriceFilter" then
            new SamePriceFilter
        else
            { abortWithMessage("Invalid filter type"); new Filter; }
        fi fi fi
    };

    getComparatorFromString(s : String) : Comparator {
        if s = "InComparator" then
            new IntComparator.init(true)
        else if s = "AlphabeticComparator" then
            new StringComparator.init(true)
        else if s = "RankComparator" then
            new RankComparator.init(true)
        else if s = "PriceComparator" then
            new ProductComparator.init(true)
        else 
            { abortWithMessage("Invalid comparator type"); new Comparator.init(true); }
        fi fi fi fi
    };

    getSortOrderFromString(s : String) : Bool {
        if s = "ascendent" then true else
        if s = "descendent" then false else
            {abortWithMessage("Invalid sort order"); true;}
        fi fi
    };

    abortWithMessage(message : String) : String {{
        out_string(message);
        out_string("\n");
        abort();
        "";
    }};
};

-- ########################################## TOSTRING ##########################################
class ToString {

    getString(object : Object) : String {
        case object of
            rank : Rank => rank.toString();
            product : Product => product.toString();
            list : List => list.toString();
            string : String => toString_String(string);
            int : Int => toString_Int(int);
            bool : Bool => toString_Bool(bool);
            object : Object => toString_Object(object);
        esac
    };

    toString_Bool(b : Bool) : String {
        b.type_name().concat("(").concat(if b then "true" else "false" fi).concat(")")
    };

    toString_Int(i : Int) : String {
        i.type_name().concat("(").concat(new A2I.i2a(i)).concat(")")
    };

    toString_String(s : String) : String {
        s.type_name().concat("(").concat(s).concat(")")
    };

    toString_Object(o : Object) : String {
        o.type_name().concat("()")
    };
};

-- Taken from the course materials
class A2I {
    c2i(char : String) : Int {
        if char = "0" then 0 else
        if char = "1" then 1 else
        if char = "2" then 2 else
        if char = "3" then 3 else
        if char = "4" then 4 else
        if char = "5" then 5 else
        if char = "6" then 6 else
        if char = "7" then 7 else
        if char = "8" then 8 else
        if char = "9" then 9 else
        { abort(); 0; }
        fi fi fi fi fi fi fi fi fi fi
    };

    i2c(i : Int) : String {
        if i = 0 then "0" else
        if i = 1 then "1" else
        if i = 2 then "2" else
        if i = 3 then "3" else
        if i = 4 then "4" else
        if i = 5 then "5" else
        if i = 6 then "6" else
        if i = 7 then "7" else
        if i = 8 then "8" else
        if i = 9 then "9" else
        { abort(); ""; }
        fi fi fi fi fi fi fi fi fi fi
    };

    a2i(s : String) : Int {
        if s.length() = 0 then 0 else
        if s.substr(0,1) = "-" then ~a2i_aux(s.substr(1,s.length()-1)) else
        if s.substr(0,1) = "+" then a2i_aux(s.substr(1,s.length()-1)) else
            a2i_aux(s)
       fi fi fi
    };

    a2i_aux(s : String) : Int {
        (let int : Int <- 0 in {	
            (let j : Int <- s.length() in
            (let i : Int <- 0 in
            while i < j loop {
                int <- int * 10 + c2i(s.substr(i,1));
                i <- i + 1;
            }
            pool));
            int;
       })
    };

   i2a(i : Int) : String {
        if i = 0 then "0" else 
        if 0 < i then i2a_aux(i) else
            "-".concat(i2a_aux(i * ~1)) 
        fi fi
   };
   
	
   i2a_aux(i : Int) : String {
        if i = 0 then "" else 
            (let next : Int <- i / 10 in
                i2a_aux(next).concat(i2c(i - next * 10)))
        fi
   };
};
