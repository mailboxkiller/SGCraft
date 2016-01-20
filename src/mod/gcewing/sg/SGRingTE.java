//------------------------------------------------------------------------------------------------
//
//   SG Craft - Stargate ring tile entity
//
//------------------------------------------------------------------------------------------------

package gcewing.sg;

import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;

public class SGRingTE extends BaseTileEntity {

    public boolean isMerged;
    public int baseX, baseY, baseZ;

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        //System.out.printf("SGRingTE.readFromNBT\n");
        super.readFromNBT(nbt);
        isMerged = nbt.getBoolean("isMerged");
        baseX = nbt.getInteger("baseX");
        baseY = nbt.getInteger("baseY");
        baseZ = nbt.getInteger("baseZ");
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        //System.out.printf("SGRingTE.writeToNBT\n");
        super.writeToNBT(nbt);
        nbt.setBoolean("isMerged", isMerged);
        nbt.setInteger("baseX", baseX);
        nbt.setInteger("baseY", baseY);
        nbt.setInteger("baseZ", baseZ);
    }
    
    public SGBaseTE getBaseTE() {
        if (isMerged) {
            TileEntity bte = worldObj.getTileEntity(baseX, baseY, baseZ);
            if (bte instanceof SGBaseTE)
                return (SGBaseTE)bte;
        }
        return null;
    }

}
