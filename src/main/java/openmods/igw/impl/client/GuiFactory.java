package openmods.igw.impl.client;

import com.google.common.collect.Sets;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import cpw.mods.fml.client.IModGuiFactory;

import openmods.config.gui.OpenModsConfigScreen;
import openmods.igw.api.OpenModsIGWApi;

import java.util.Set;

@SuppressWarnings({"WeakerAccess", "unused"})
public class GuiFactory implements IModGuiFactory {

	public static class ConfigGui extends OpenModsConfigScreen {

		public ConfigGui(final GuiScreen parent) {
			// Don't remove generics unless you work in Java 8 - TSM
			super(parent,
					OpenModsIGWApi.get().<String>constant("MODID"),
					OpenModsIGWApi.get().<String>constant("NAME"));
		}
	}

	@Override
	public void initialize(final Minecraft mcInstance) { }

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return GuiFactory.ConfigGui.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return Sets.newHashSet();
	}

	@Override
	public RuntimeOptionGuiHandler getHandlerFor(final RuntimeOptionCategoryElement element) {
		return null;
	}
}