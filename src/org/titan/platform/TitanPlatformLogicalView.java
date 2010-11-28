/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.titan.platform;

import java.awt.Image;
import javax.swing.Action;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;
import org.titan.platform.wizards.section.SectionWizardAction;

public class TitanPlatformLogicalView implements LogicalViewProvider {

    private final TitanPlatformProject project;

    public TitanPlatformLogicalView(TitanPlatformProject project) {
        this.project = project;
    }

    @Override
    public Node createLogicalView() {
        try {
            //Get the Text directory, creating if deleted
            FileObject dir = project.getProjectDirectory();

            //Get the DataObject that represents it
            DataFolder textDataObject =
                    DataFolder.findFolder(dir);

            //Get its default node-we'll wrap our node around it to change the
            //display name, icon, etc
            Node realTextFolderNode = textDataObject.getNodeDelegate();

            //This FilterNode will be our project node
            return new RootNode(realTextFolderNode, project);

        } catch (DataObjectNotFoundException donfe) {
            Exceptions.printStackTrace(donfe);
            //Fallback-the directory couldn't be created -
            //read-only filesystem or something evil happened
            return new AbstractNode(Children.LEAF);
        }
    }

    private static final class RootNode extends FilterNode {

        final TitanPlatformProject project;

        public RootNode(Node node, TitanPlatformProject project) throws DataObjectNotFoundException {
            super(node, new FilterNode.Children(node),
                    new ProxyLookup(new Lookup[]{Lookups.singleton(project),
                        node.getLookup()
                    }));
            this.project = project;
        }

        @Override
        public Action[] getActions(boolean arg0) {
            Action[] nodeActions = new Action[8];
            nodeActions[0] = (Action) CommonProjectActions.newFileAction();
            nodeActions[1] = (Action) CommonProjectActions.copyProjectAction();
            nodeActions[2] = (Action) CommonProjectActions.deleteProjectAction();
            nodeActions[5] = (Action) CommonProjectActions.setAsMainProjectAction();
            nodeActions[6] = (Action) CommonProjectActions.closeProjectAction();
            nodeActions[7] = new SectionWizardAction();
            return nodeActions;
        }

        @Override
        public Image getIcon(int type) {
            return ImageUtilities.loadImage(TitanPlataformProjectType.ICON_RESOURCE_PATH);
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
