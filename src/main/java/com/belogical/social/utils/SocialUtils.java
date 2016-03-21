/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belogical.social.utils;

import com.belogical.social.Social;
import com.belogical.social.User;
import java.util.List;
import java.util.Random;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

/**
 *
 * @author yirou
 */
public class SocialUtils {

    private static final String STYLESHEET
            = "node {"
            + "	size: 15px;"
            + "	fill-color: black;"
            + "	z-index: 0;"
            + "shape:box;"
            + "}"
            + "node.marked {"
            + "	fill-color: red;"
            + "}"
            + "node.glandeur {"
            + "	fill-color: #631B75;"
            + "size: 10px;"
            + "}"
            + "node.diffuseur {"
            + "	fill-color: #4293EB;"
            + "size: 30px;"
            + "}"
            + "node.ignorant {"
            + "	fill-color: green;"
            + "}"
            + "edge{"
            + " shape: box;"
            + "fill-mode: dyn-plain;"
            + "	fill-color: #C9C8C5;"
            + "}"
            + "edge.contamine{"
            + "fill-color:red;"
            + "size:10px;"
            + "}"
            + "edge.nonContamine{"
            + "fill-color:black;"
            + "}"
            + "node.contamine{"
            + "fill-color:red;}"
            + "node.rumorLuncher{"
            + "fill-color:#C97212;"
            + "size: 40px;}"
            + "graph {"
            + "	fill-image: url('globe.jpg');"
            + "fill-mode:image-scaled-ratio-min;"
            + "}";

    public static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void initGraph() {
        Social social = Social.getInstance();
        Graph graph = new MultiGraph("Social");
        graph.addAttribute("ui.stylesheet", STYLESHEET);
        graph.setAutoCreate(true);
        Node node;
        System.out.println("Création du graphe");
        for (User u : social.getUsers()) {
            node = graph.addNode(u.getId() + "");
//            node.setAttribute("id", u.getId());
            node.addAttribute("ui.label", u.getId());
            displayColorNode(u, graph);

        }
        for (User u : social.getUsers()) {
            addFriendRelation(u, graph);
//            System.out.println("moi :"+u.getId()+" Mes amis "+u.getMesAmis());
        }

        social.setGraph(graph);
        graph.display(true);
    }

    private static void addFriendRelation(User user, Graph graph) {
        Node n1 = graph.getNode(user.getId() + "");
        Node n2;
        Edge e;
        for (User u : user.getMesAmis()) {
            n2 = graph.getNode(u.getId() + "");
            e = graph.getEdge(user.getId() + "-" + u.getId());
            if (e == null) {
                e = graph.getEdge(u.getId() + "-" + user.getId());
                if (e == null) {
                    graph.addEdge(user.getId() + "-" + u.getId(), n1, n2);
                }
            }
        }
    }

    public static Node getNodeWhoHaveMoreFriend(Graph graph) {
        Node result;
        int c;
        List<Node> nodes = (List<Node>) graph.getNodeSet();
        int max = nodes.get(0).getDegree();
        result = nodes.get(0);
        for (Node node : nodes) {
            c = node.getDegree();
            if (c > max) {
                max = c;
                result = node;
            }
        }
        return result;
    }

    private static void displayColorNode(User u, Graph graph) {
        Node node = graph.getNode(u.getId());
        switch (u.getTypePersonne()) {
            case Diffiseur:
                if (!u.isRumorLuncher()) {
                    node.addAttribute("ui.class", "diffuseur");
                }
                break;
            case Glandeur:
                node.addAttribute("ui.class", "glandeur");
                break;

            case Ignorant:
                node.addAttribute("ui.class", "ignorant");
                break;
        }
    }
}
