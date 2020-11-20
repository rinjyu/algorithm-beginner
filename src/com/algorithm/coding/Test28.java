package com.algorithm.coding;

import java.util.Comparator;

public class Test28 {

    public static void main(String[] args){
        // write your code here
    }

    public class LinkedList<E>{

        class Node<E>{
            private E data;
            private Node<E> next;

            Node(E data, Node<E> next){
                this.data = data;
                this.next = next;
            }
        }

        private Node<E> head;
        private Node<E> selNode;

        public LinkedList(){
            head = selNode = null;
        }

        public E search(E object, Comparator<? super E> c){
            Node<E> currentNode = head;

            while (currentNode != null){
                if(c.compare(object, currentNode.data) == 0){
                    selNode = currentNode;
                    return currentNode.data;
                }
                selNode = currentNode.next;
            }
            return null;
        }

        public void addFirst(E object){
            Node<E> currentNode = head;
            head = selNode = new Node<E>(object, currentNode);
        }

        public void addLast(E object){
            if(head == null){
                addFirst(object);
            }else{
                Node<E> currentNode = head;
                while (currentNode.next != null){
                    currentNode = currentNode.next;
                }
                currentNode.next = selNode = new Node<E>(object, null);
            }
        }

        public void removeFirst(){
            if(head != null){
                head = selNode = head.next;
            }
        }

        public void removeLast(){
            if(head != null){
                if(head.next == null) {
                    removeFirst();
                }else{
                    Node<E> currentNode = head;
                    Node<E> prevNode = head;

                    while(currentNode.next != null){
                        prevNode = currentNode;
                        currentNode = currentNode.next;
                    }
                    prevNode.next = null;
                    selNode = prevNode;
                }
            }
        }

        public void remove(Node node){
            if(head != null){
                if(node == head){
                    removeFirst();
                }else{
                    Node<E> currentNode = head;

                    while (currentNode.next != node){
                        currentNode = currentNode.next;
                        if(currentNode == null){
                            return;
                        }
                    }
                    currentNode.next = node.next;
                    selNode = currentNode;
                }
            }
        }

        public void removeCurrentNode(){
            remove(selNode);
        }

        public void clear(){
            while (head != null){
                removeFirst();
            }
            selNode = null;
        }

        public boolean next(){
            if(selNode == null || selNode.next == null){
                return false;
            }
            selNode = selNode.next;
            return true;
        }

        public void printCurrentNode(){
            if(selNode == null){
                System.out.println("선택한 노드가 없음");
            }else{
                System.out.println(selNode.data);
            }
        }

        public void dump(){
            Node<E> currentNode = head;
            while (currentNode != null){
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }
    }
}
