
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.client.model.Modelprimed_tnt_sponge_v4;
import palamod.client.model.Modelprimed_tnt_sponge_v3;
import palamod.client.model.Modelprimed_tnt_sponge_v2;
import palamod.client.model.Modelprimed_tnt_sponge_v1;
import palamod.client.model.Modeldynamite_model;
import palamod.client.model.ModelGolem_gplacement_vlegtest;
import palamod.client.model.ModelGolem_gplacement2;
import palamod.client.model.ModelBIG_dynamitev2;
import palamod.client.model.ModelBIG_dynamite2;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PalamodModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelprimed_tnt_sponge_v1.LAYER_LOCATION, Modelprimed_tnt_sponge_v1::createBodyLayer);
		event.registerLayerDefinition(ModelBIG_dynamite2.LAYER_LOCATION, ModelBIG_dynamite2::createBodyLayer);
		event.registerLayerDefinition(Modelprimed_tnt_sponge_v2.LAYER_LOCATION, Modelprimed_tnt_sponge_v2::createBodyLayer);
		event.registerLayerDefinition(Modeldynamite_model.LAYER_LOCATION, Modeldynamite_model::createBodyLayer);
		event.registerLayerDefinition(ModelBIG_dynamitev2.LAYER_LOCATION, ModelBIG_dynamitev2::createBodyLayer);
		event.registerLayerDefinition(ModelGolem_gplacement_vlegtest.LAYER_LOCATION, ModelGolem_gplacement_vlegtest::createBodyLayer);
		event.registerLayerDefinition(Modelprimed_tnt_sponge_v3.LAYER_LOCATION, Modelprimed_tnt_sponge_v3::createBodyLayer);
		event.registerLayerDefinition(ModelGolem_gplacement2.LAYER_LOCATION, ModelGolem_gplacement2::createBodyLayer);
		event.registerLayerDefinition(Modelprimed_tnt_sponge_v4.LAYER_LOCATION, Modelprimed_tnt_sponge_v4::createBodyLayer);
	}
}
