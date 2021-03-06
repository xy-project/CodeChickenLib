package codechicken.lib.model;

import codechicken.lib.util.TransformUtils;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraftforge.client.model.ItemLayerModel;
import net.minecraftforge.common.model.IModelState;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by covers1624 on 13/02/2017.
 *///TODO, May be cleaner to move the back end to TAS... instead of Lists.
public class ItemQuadBakery {

    public static List<BakedQuad> bakeItem(TextureAtlasSprite... sprites) {
        return bakeItem(ImmutableList.copyOf(sprites));
    }

    public static List<BakedQuad> bakeItem(List<TextureAtlasSprite> sprites) {
        return bakeItem(sprites, DefaultVertexFormats.ITEM, TransformUtils.DEFAULT_ITEM);
    }

    public static List<BakedQuad> bakeItem(List<TextureAtlasSprite> sprites, IModelState state) {
        return bakeItem(sprites, DefaultVertexFormats.ITEM, state);
    }

    public static List<BakedQuad> bakeItem(List<TextureAtlasSprite> sprites, VertexFormat format) {
        return bakeItem(sprites, format, TransformUtils.DEFAULT_ITEM);
    }

    public static List<BakedQuad> bakeItem(List<TextureAtlasSprite> sprites, VertexFormat format, IModelState state) {
        List<BakedQuad> quads = new LinkedList<>();
        for (int i = 0; i < sprites.size(); i++) {
            TextureAtlasSprite sprite = sprites.get(i);
            quads.addAll(ItemLayerModel.getQuadsForSprite(i, sprite, format, state.apply(Optional.empty())));
        }
        return quads;
    }

}
