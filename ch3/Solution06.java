/*********************************************************************************
*     File Name           :     Solution06.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-19 14:59]
*     Last Modified       :     [2015-09-19 15:23]
*     Description         :     Animal Shelter 
**********************************************************************************/

import java.util.LinkedList;

public class Solution06
{
    public static class Animal {
        public static enum Type {
            CAT, DOG;
        }

        Type type;

        Animal(Type type) {
            this.type = type;
        }

        boolean isCat() {
            return type == Type.CAT;
        }

        boolean isDog() {
            return type == Type.DOG;
        }
    }

    public static class AnimalShelter {
        LinkedList<Animal> list;

        public AnimalShelter() {
            list = new LinkedList<Animal>();
        }

        public int enqueue(Animal t) {
            list.addLast(t);
            return 0;
        }

        public Animal dequeueAny() {
            return list.remove();
        }

        public Animal dequeueDog() {
            for (int i = 0; i < list.size(); i++) {
                Animal t = list.get(i);
                if (t.isDog()) {
                    list.remove(i);
                    return t;
                }
            }
            return null;
        }

        public Animal dequeueCat() {
            for (int i = 0; i < list.size(); i++) {
                Animal t = list.get(i);
                if (t.isCat()) {
                    list.remove(i);
                    return t;
                }
            }
            return null;
        }
    }

    public static void main(String [] args) {
        AnimalShelter foo = new AnimalShelter();

        Animal c1 = new Animal(Animal.Type.CAT);
        Animal c2 = new Animal(Animal.Type.CAT);
        Animal c3 = new Animal(Animal.Type.CAT);
        Animal d1 = new Animal(Animal.Type.DOG);
        Animal d2 = new Animal(Animal.Type.DOG);
        Animal d3 = new Animal(Animal.Type.DOG);

        foo.enqueue(c1);
        assert foo.dequeueDog() == null;
        assert foo.dequeueAny() == c1;

        foo.enqueue(c1);
        foo.enqueue(d1);
        foo.enqueue(d2);
        foo.enqueue(d3);
        foo.enqueue(c2);
        foo.enqueue(c3);

        assert foo.dequeueDog() == d1;
        assert foo.dequeueDog() == d2;
        assert foo.dequeueAny() == c1;
        assert foo.dequeueCat() == c2;
        assert foo.dequeueAny() == d3;
    }

    // improvement:
    // use extra space to record the previous CAT or DOG to avoid search
}

