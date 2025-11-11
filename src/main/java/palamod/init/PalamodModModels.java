/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.client.model.*;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class PalamodModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelprimed_tnt_sponge_v1.LAYER_LOCATION, Modelprimed_tnt_sponge_v1::createBodyLayer);
		event.registerLayerDefinition(ModelBIG_dynamite2.LAYER_LOCATION, ModelBIG_dynamite2::createBodyLayer);
		event.registerLayerDefinition(Modelprimed_tnt_sponge_v2.LAYER_LOCATION, Modelprimed_tnt_sponge_v2::createBodyLayer);
		event.registerLayerDefinition(Modeldynamite_model.LAYER_LOCATION, Modeldynamite_model::createBodyLayer);
		event.registerLayerDefinition(ModelBIG_dynamitev2.LAYER_LOCATION, ModelBIG_dynamitev2::createBodyLayer);
		event.registerLayerDefinition(ModelGolem_gplacement_vlegtest.LAYER_LOCATION, ModelGolem_gplacement_vlegtest::createBodyLayer);
		event.registerLayerDefinition(ModelGolem_gplacement2.LAYER_LOCATION, ModelGolem_gplacement2::createBodyLayer);
		event.registerLayerDefinition(Modelprimed_tnt_sponge_v3.LAYER_LOCATION, Modelprimed_tnt_sponge_v3::createBodyLayer);
		event.registerLayerDefinition(ModelDancarok_V1_Converted.LAYER_LOCATION, ModelDancarok_V1_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelprimed_tnt_sponge_v4.LAYER_LOCATION, Modelprimed_tnt_sponge_v4::createBodyLayer);
	}
}