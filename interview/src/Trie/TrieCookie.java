package Trie;

import java.util.LinkedList;
import java.util.List;

public class TrieCookie {

    private Node root;
    private List<String> storedValues = new LinkedList<String>();

    private class Node {
        Character value;
        Node next;
        List<Node> branch = new LinkedList<Node>();
    }

    public void add(String value) {
        root = add(root, value);
    }

    private Node add(Node root, String strValue) {
        if (strValue == null || strValue.isEmpty()) {
            root = new Node();
            root.value = "$".charAt(0); // end of string
            return root;
        }

        Character value = strValue.charAt(0);
        String leftOver = strValue.length() > 1 ? strValue.substring(1) : null;

        if (root == null) {
            root = new Node();
            root.value = value;
            root.next = add(root.next, leftOver);
        } else if (root.value.equals(value)) {
            root.next = add(root.next, leftOver);
        } else {
            if (root.branch.isEmpty()) {
                root.branch.add(add(null, strValue));
            } else {
                root.branch.add(add(root.branch.get(0), strValue));
            }
        }
        return root;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
        addValues("", root);
        return storedValues.toString();
    }

    private void addValues(String tillNow, Node root) {
        if (root == null) {
            return;
        }
        if (root.value.equals("$".charAt(0))) {
            storedValues.add(tillNow);
        } else {
            addValues(tillNow + root.value, root.next);
        }
        if (!root.branch.isEmpty()) {
            addValues(tillNow, root.branch.get(0));
        }
    }

    public boolean contains(String value) {
        return root != null && contains(root, value);
    }

    private boolean contains(Node root, String value) {
        if (root.value.equals(value.charAt(0))) {
            return value.length() == 1
                    || contains(root.next, value.substring(1));
        } else if (!root.branch.isEmpty()) {
            return contains(root.branch.get(0), value);
        }
        return false;
    }

    public List<String> getAutoSuggest(String value) {
        storedValues = new LinkedList<String>();
        if (root == null) {
            return storedValues;
        }
        addAutoSuggestValues(root, value, value);
        return storedValues;
    }

    private void addAutoSuggestValues(Node root, String tillNow, String leftover) {
        if (leftover != null) {
            if (root.value.equals(leftover.charAt(0))) {
                leftover = leftover.length() > 1 ? leftover.substring(1) : null;
                addAutoSuggestValues(root.next, tillNow, leftover);
            } else if (!root.branch.isEmpty()) {
                addAutoSuggestValues(root.branch.get(0), tillNow, leftover);
            }
            return;
        }
        if (root == null) {
            return;
        }
        if (root.value.equals("$".charAt(0))) {
            storedValues.add(tillNow);
        } else {
            addAutoSuggestValues(root.next, tillNow + root.value, leftover);
        }
        if (!root.branch.isEmpty()) {
            addAutoSuggestValues(root.branch.get(0), tillNow, leftover);

        }
    }

    public static void main(String[] args) {
        TrieCookie t = new TrieCookie();
        t.add("kid");
        t.add("kite");
        t.add("add");
        t.add("additional");
        t.add("kitten");
        System.out.println(t);
        System.out.println("Contains kite: " + t.contains("kite"));
        System.out.println("Contains kiddo: " + t.contains("kiddo"));
        System.out.println(t.getAutoSuggest("kit"));
    }
}

