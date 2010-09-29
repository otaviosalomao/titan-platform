/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform.projectType;

import java.awt.Image;
import javax.swing.Action;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;

/**
 *
 * @author marcos
 */
public class TitanPlatformLogicalView implements LogicalViewProvider {

    private final TitanPlatformProject project;

    public TitanPlatformLogicalView(TitanPlatformProject project) {
        this.project = project;
    }

    @Override
    public org.openide.nodes.Node createLogicalView() {
        try {


            //This FilterNode will be our project node
             DataFolder textDataObject = DataFolder.findFolder(project.getProjectDirectory());
            return new RootNode( textDataObject.getNodeDelegate(), project);

        } catch (DataObjectNotFoundException donfe) {
            Exceptions.printStackTrace(donfe);
            //Fallback-the directory couldn't be created -
            //read-only filesystem or something evil happened
            return new AbstractNode(Children.LEAF);
        }
    }

    /** This is the node you actually see in the project tab for the project */
    private static final class RootNode extends FilterNode {

        final TitanPlatformProject project;

        public RootNode(Node node, TitanPlatformProject project) throws DataObjectNotFoundException {
        /*    super(node, new FilterNode.Children(node),
                    //The projects system wants the project in the Node's lookup.
                    //NewAction and friends want the original Node's lookup.
                    //Make a merge of both
                    new ProxyLookup(new Lookup[]{Lookups.singleton(project),
                        node.getLookup()
                    }));
            this.project = project;*/

            super(node);
            this.project = project;
        }

        @Override
        public Action[] getActions(boolean arg0) {
            Action[] nodeActions = new Action[7];
            nodeActions[0] = CommonProjectActions.newFileAction();
            nodeActions[1] = CommonProjectActions.copyProjectAction();
            nodeActions[2] = CommonProjectActions.deleteProjectAction();
            nodeActions[5] = CommonProjectActions.setAsMainProjectAction();
            nodeActions[6] = CommonProjectActions.closeProjectAction();
            return nodeActions;
        }

        @Override
        public Image getIcon(int type) {
            return ImageUtilities.loadImage("org/ledes/titan/titan.ico");
        }

        @Override
        public Image getOpenedIcon(int type) {
            return getIcon(type);
        }

        @Override
        public String getDisplayName() {
            return project.getProjectDirectory().getName();
        }

    }

    @Override
    public Node findPath(Node root, Object target) {
        //leave unimplemented for now
        return null;
    }

}