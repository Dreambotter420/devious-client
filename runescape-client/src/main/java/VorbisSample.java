import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("VorbisSample")
public class VorbisSample extends Node {
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lce;"
	)
	static class60 field393;
	@ObfuscatedName("ap")
	static int field394;
	@ObfuscatedName("aa")
	static int field395;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "[Lcw;"
	)
	static VorbisCodebook[] field396;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "[Lbo;"
	)
	static VorbisFloor[] field397;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "[Lbz;"
	)
	static VorbisResidue[] field398;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "[Lbc;"
	)
	static VorbisMapping[] field399;
	@ObfuscatedName("an")
	static boolean[] field400;
	@ObfuscatedName("ar")
	static int[] field401;
	@ObfuscatedName("ab")
	static boolean field418;
	@ObfuscatedName("ay")
	static float[] field417;
	@ObfuscatedName("aj")
	static float[] field409;
	@ObfuscatedName("av")
	static float[] field403;
	@ObfuscatedName("aw")
	static float[] field411;
	@ObfuscatedName("ak")
	static float[] field412;
	@ObfuscatedName("bh")
	static float[] field413;
	@ObfuscatedName("bj")
	static int[] field414;
	@ObfuscatedName("bk")
	static int[] field389;
	@ObfuscatedName("au")
	byte[][] field406;
	@ObfuscatedName("ae")
	@Export("sampleRate")
	int sampleRate;
	@ObfuscatedName("ao")
	@Export("sampleCount")
	int sampleCount;
	@ObfuscatedName("at")
	@Export("start")
	int start;
	@ObfuscatedName("ac")
	@Export("end")
	int end;
	@ObfuscatedName("ai")
	boolean field392;
	@ObfuscatedName("ag")
	float[] field408;
	@ObfuscatedName("am")
	int field404;
	@ObfuscatedName("ax")
	int field405;
	@ObfuscatedName("ah")
	boolean field407;
	@ObfuscatedName("as")
	float[] field410;
	@ObfuscatedName("bv")
	@Export("samples")
	byte[] samples;
	@ObfuscatedName("bt")
	int field387;
	@ObfuscatedName("bd")
	int field402;

	static {
		field393 = new class60();
		field418 = false;
	}

	VorbisSample(byte[] var1) {
		this.read(var1);
	}

	@ObfuscatedName("ae")
	@Export("read")
	void read(byte[] var1) {
		Buffer var2 = new Buffer(var1);
		this.sampleRate = var2.readInt();
		this.sampleCount = var2.readInt();
		this.start = var2.readInt();
		this.end = var2.readInt();
		if (this.end < 0) {
			this.end = ~this.end;
			this.field392 = true;
		}

		int var3 = var2.readInt();
		this.field406 = new byte[var3][];

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = 0;

			int var6;
			do {
				var6 = var2.readUnsignedByte();
				var5 += var6;
			} while(var6 >= 255);

			byte[] var7 = new byte[var5];
			var2.readBytes(var7, 0, var5);
			this.field406[var4] = var7;
		}

	}

	@ObfuscatedName("at")
	float[] method1102(int var1) {
		class60 var2 = new class60();
		var2.method1163(this.field406[var1], 0);
		this.field410 = new float[field395];
		var2.method1162();
		int var3 = var2.method1161(class16.iLog(field401.length - 1));
		boolean var4 = field400[var3];
		int var5 = var4 ? field395 : field394;
		boolean var6 = false;
		boolean var7 = false;
		if (var4) {
			var6 = var2.method1162() != 0;
			var7 = var2.method1162() != 0;
		}

		int var8 = var5 >> 1;
		int var9;
		int var10;
		int var11;
		if (var4 && !var6) {
			var9 = (var5 >> 2) - (field394 >> 2);
			var10 = (field394 >> 2) + (var5 >> 2);
			var11 = field394 >> 1;
		} else {
			var9 = 0;
			var10 = var8;
			var11 = var5 >> 1;
		}

		int var12;
		int var13;
		int var14;
		if (var4 && !var7) {
			var12 = var5 - (var5 >> 2) - (field394 >> 2);
			var13 = (field394 >> 2) + (var5 - (var5 >> 2));
			var14 = field394 >> 1;
		} else {
			var12 = var8;
			var13 = var5;
			var14 = var5 >> 1;
		}

		VorbisMapping var15 = field399[field401[var3]];
		int var16 = var15.field374;
		int var17 = var15.field376[var16];
		class59 var18 = field397[var17].method784(var2);
		boolean var19 = !var18.method1154();

		int var20;
		for (var20 = 0; var20 < var15.field375; ++var20) {
			VorbisResidue var45 = field398[var15.field377[var20]];
			float[] var47 = this.field410;
			var45.method897(var47, var5 >> 1, var19, var2);
		}

		if (var18.method1154()) {
			var16 = var15.field374;
			int var10000 = var15.field376[var16];
			var18.method1153(this.field410, var5 >> 1);
		}

		int var21;
		int var22;
		if (!var18.method1154()) {
			for (var20 = var5 >> 1; var20 < var5; ++var20) {
				this.field410[var20] = 0.0F;
			}
		} else {
			var20 = var5 >> 1;
			var21 = var5 >> 2;
			var22 = var5 >> 3;
			float[] var23 = this.field410;

			int var24;
			for (var24 = 0; var24 < var20; ++var24) {
				var23[var24] *= 0.5F;
			}

			for (var24 = var20; var24 < var5; ++var24) {
				var23[var24] = -var23[var5 - var24 - 1];
			}

			float[] var43 = var4 ? field411 : field417;
			float[] var25 = var4 ? field412 : field409;
			float[] var26 = var4 ? field413 : field403;
			int[] var27 = var4 ? field389 : field414;

			int var28;
			float var29;
			float var30;
			float var31;
			float var32;
			for (var28 = 0; var28 < var21; ++var28) {
				var29 = var23[var28 * 4] - var23[var5 - var28 * 4 - 1];
				var30 = var23[var28 * 4 + 2] - var23[var5 - var28 * 4 - 3];
				var31 = var43[var28 * 2];
				var32 = var43[var28 * 2 + 1];
				var23[var5 - var28 * 4 - 1] = var29 * var31 - var30 * var32;
				var23[var5 - var28 * 4 - 3] = var29 * var32 + var30 * var31;
			}

			float var33;
			float var34;
			for (var28 = 0; var28 < var22; ++var28) {
				var29 = var23[var20 + var28 * 4 + 3];
				var30 = var23[var20 + var28 * 4 + 1];
				var31 = var23[var28 * 4 + 3];
				var32 = var23[var28 * 4 + 1];
				var23[var20 + var28 * 4 + 3] = var29 + var31;
				var23[var20 + var28 * 4 + 1] = var30 + var32;
				var33 = var43[var20 - 4 - var28 * 4];
				var34 = var43[var20 - 3 - var28 * 4];
				var23[var28 * 4 + 3] = (var29 - var31) * var33 - (var30 - var32) * var34;
				var23[var28 * 4 + 1] = (var30 - var32) * var33 + (var29 - var31) * var34;
			}

			var28 = class16.iLog(var5 - 1);

			int var48;
			int var49;
			int var50;
			int var51;
			for (var48 = 0; var48 < var28 - 3; ++var48) {
				var49 = var5 >> var48 + 2;
				var50 = 8 << var48;

				for (var51 = 0; var51 < 2 << var48; ++var51) {
					int var52 = var5 - var49 * var51 * 2;
					int var53 = var5 - var49 * (var51 * 2 + 1);

					for (int var35 = 0; var35 < var5 >> var48 + 4; ++var35) {
						int var36 = var35 * 4;
						float var37 = var23[var52 - 1 - var36];
						float var38 = var23[var52 - 3 - var36];
						float var39 = var23[var53 - 1 - var36];
						float var40 = var23[var53 - 3 - var36];
						var23[var52 - 1 - var36] = var37 + var39;
						var23[var52 - 3 - var36] = var38 + var40;
						float var41 = var43[var35 * var50];
						float var42 = var43[var35 * var50 + 1];
						var23[var53 - 1 - var36] = (var37 - var39) * var41 - (var38 - var40) * var42;
						var23[var53 - 3 - var36] = (var38 - var40) * var41 + (var37 - var39) * var42;
					}
				}
			}

			for (var48 = 1; var48 < var22 - 1; ++var48) {
				var49 = var27[var48];
				if (var48 < var49) {
					var50 = var48 * 8;
					var51 = var49 * 8;
					var33 = var23[var50 + 1];
					var23[var50 + 1] = var23[var51 + 1];
					var23[var51 + 1] = var33;
					var33 = var23[var50 + 3];
					var23[var50 + 3] = var23[var51 + 3];
					var23[var51 + 3] = var33;
					var33 = var23[var50 + 5];
					var23[var50 + 5] = var23[var51 + 5];
					var23[var51 + 5] = var33;
					var33 = var23[var50 + 7];
					var23[var50 + 7] = var23[var51 + 7];
					var23[var51 + 7] = var33;
				}
			}

			for (var48 = 0; var48 < var20; ++var48) {
				var23[var48] = var23[var48 * 2 + 1];
			}

			for (var48 = 0; var48 < var22; ++var48) {
				var23[var5 - 1 - var48 * 2] = var23[var48 * 4];
				var23[var5 - 2 - var48 * 2] = var23[var48 * 4 + 1];
				var23[var5 - var21 - 1 - var48 * 2] = var23[var48 * 4 + 2];
				var23[var5 - var21 - 2 - var48 * 2] = var23[var48 * 4 + 3];
			}

			for (var48 = 0; var48 < var22; ++var48) {
				var30 = var26[var48 * 2];
				var31 = var26[var48 * 2 + 1];
				var32 = var23[var20 + var48 * 2];
				var33 = var23[var20 + var48 * 2 + 1];
				var34 = var23[var5 - 2 - var48 * 2];
				float var54 = var23[var5 - 1 - var48 * 2];
				float var55 = var31 * (var32 - var34) + var30 * (var33 + var54);
				var23[var20 + var48 * 2] = (var32 + var34 + var55) * 0.5F;
				var23[var5 - 2 - var48 * 2] = (var32 + var34 - var55) * 0.5F;
				var55 = var31 * (var33 + var54) - var30 * (var32 - var34);
				var23[var20 + var48 * 2 + 1] = (var33 - var54 + var55) * 0.5F;
				var23[var5 - 1 - var48 * 2] = (-var33 + var54 + var55) * 0.5F;
			}

			for (var48 = 0; var48 < var21; ++var48) {
				var23[var48] = var23[var20 + var48 * 2] * var25[var48 * 2] + var23[var20 + var48 * 2 + 1] * var25[var48 * 2 + 1];
				var23[var20 - 1 - var48] = var23[var20 + var48 * 2] * var25[var48 * 2 + 1] - var23[var20 + var48 * 2 + 1] * var25[var48 * 2];
			}

			for (var48 = 0; var48 < var21; ++var48) {
				var23[var48 + (var5 - var21)] = -var23[var48];
			}

			for (var48 = 0; var48 < var21; ++var48) {
				var23[var48] = var23[var21 + var48];
			}

			for (var48 = 0; var48 < var21; ++var48) {
				var23[var21 + var48] = -var23[var21 - var48 - 1];
			}

			for (var48 = 0; var48 < var21; ++var48) {
				var23[var20 + var48] = var23[var5 - var48 - 1];
			}

			float[] var57;
			for (var48 = var9; var48 < var10; ++var48) {
				var30 = (float)Math.sin(((double)(var48 - var9) + 0.5D) / (double)var11 * 0.5D * 3.141592653589793D);
				var57 = this.field410;
				var57[var48] *= (float)Math.sin(1.5707963267948966D * (double)var30 * (double)var30);
			}

			for (var48 = var12; var48 < var13; ++var48) {
				var30 = (float)Math.sin(((double)(var48 - var12) + 0.5D) / (double)var14 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
				var57 = this.field410;
				var57[var48] *= (float)Math.sin(1.5707963267948966D * (double)var30 * (double)var30);
			}
		}

		float[] var44 = null;
		if (this.field404 > 0) {
			var21 = var5 + this.field404 >> 2;
			var44 = new float[var21];
			int var46;
			if (!this.field407) {
				for (var22 = 0; var22 < this.field405; ++var22) {
					var46 = var22 + (this.field404 >> 1);
					var44[var22] += this.field408[var46];
				}
			}

			if (var18.method1154()) {
				for (var22 = var9; var22 < var5 >> 1; ++var22) {
					var46 = var44.length - (var5 >> 1) + var22;
					var44[var46] += this.field410[var22];
				}
			}
		}

		float[] var56 = this.field408;
		this.field408 = this.field410;
		this.field410 = var56;
		this.field404 = var5;
		this.field405 = var13 - (var5 >> 1);
		this.field407 = !var18.method1154();
		return var44;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "([I)Lbu;"
	)
	@Export("toRawSound")
	RawSound toRawSound(int[] var1) {
		if (var1 != null && var1[0] <= 0) {
			return null;
		} else {
			if (this.samples == null) {
				this.field404 = 0;
				this.field408 = new float[field395];
				this.samples = new byte[this.sampleCount];
				this.field387 = 0;
				this.field402 = 0;
			}

			for (; this.field402 < this.field406.length; ++this.field402) {
				if (var1 != null && var1[0] <= 0) {
					return null;
				}

				float[] var2 = this.method1102(this.field402);
				if (var2 != null) {
					int var3 = this.field387;
					int var4 = var2.length;
					if (var4 > this.sampleCount - var3) {
						var4 = this.sampleCount - var3;
					}

					for (int var5 = 0; var5 < var4; ++var5) {
						int var6 = (int)(128.0F + var2[var5] * 128.0F);
						if ((var6 & -256) != 0) {
							var6 = ~var6 >> 31;
						}

						this.samples[var3++] = (byte)(var6 - 128);
					}

					if (var1 != null) {
						var1[0] -= var3 - this.field387;
					}

					this.field387 = var3;
				}
			}

			this.field408 = null;
			byte[] var7 = this.samples;
			this.samples = null;
			return new RawSound(this.sampleRate, var7, this.start, this.end, this.field392);
		}
	}

	@ObfuscatedName("au")
	@Export("float32Unpack")
	static float float32Unpack(int var0) {
		int var1 = var0 & 2097151;
		int var2 = var0 & Integer.MIN_VALUE;
		int var3 = (var0 & 2145386496) >> 21;
		if (var2 != 0) {
			var1 = -var1;
		}

		return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
	}

	@ObfuscatedName("ao")
	static void method1101(byte[] var0) {
		class60 var1 = field393;
		var1.method1163(var0, 0);
		field394 = 1 << var1.method1161(4);
		field395 = 1 << var1.method1161(4);

		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		for (var2 = 0; var2 < 2; ++var2) {
			var3 = var2 != 0 ? field395 : field394;
			var4 = var3 >> 1;
			var5 = var3 >> 2;
			var6 = var3 >> 3;
			float[] var19 = new float[var4];

			for (int var8 = 0; var8 < var5; ++var8) {
				var19[var8 * 2] = (float)Math.cos((double)(var8 * 4) * 3.141592653589793D / (double)var3);
				var19[var8 * 2 + 1] = -((float)Math.sin((double)(var8 * 4) * 3.141592653589793D / (double)var3));
			}

			float[] var20 = new float[var4];

			for (int var9 = 0; var9 < var5; ++var9) {
				var20[var9 * 2] = (float)Math.cos((double)(var9 * 2 + 1) * 3.141592653589793D / (double)(var3 * 2));
				var20[var9 * 2 + 1] = (float)Math.sin((double)(var9 * 2 + 1) * 3.141592653589793D / (double)(var3 * 2));
			}

			float[] var21 = new float[var5];

			for (int var10 = 0; var10 < var6; ++var10) {
				var21[var10 * 2] = (float)Math.cos((double)(var10 * 4 + 2) * 3.141592653589793D / (double)var3);
				var21[var10 * 2 + 1] = -((float)Math.sin((double)(var10 * 4 + 2) * 3.141592653589793D / (double)var3));
			}

			int[] var22 = new int[var6];
			int var11 = class16.iLog(var6 - 1);

			for (int var12 = 0; var12 < var6; ++var12) {
				int var16 = var12;
				int var17 = var11;

				int var18;
				for (var18 = 0; var17 > 0; --var17) {
					var18 = var18 << 1 | var16 & 1;
					var16 >>>= 1;
				}

				var22[var12] = var18;
			}

			if (var2 != 0) {
				field411 = var19;
				field412 = var20;
				field413 = var21;
				field389 = var22;
			} else {
				field417 = var19;
				field409 = var20;
				field403 = var21;
				field414 = var22;
			}
		}

		var2 = var1.method1161(8) + 1;
		field396 = new VorbisCodebook[var2];

		for (var3 = 0; var3 < var2; ++var3) {
			field396[var3] = new VorbisCodebook();
		}

		var3 = var1.method1161(6) + 1;

		for (var4 = 0; var4 < var3; ++var4) {
			var1.method1161(16);
		}

		var3 = var1.method1161(6) + 1;
		field397 = new VorbisFloor[var3];

		for (var4 = 0; var4 < var3; ++var4) {
			field397[var4] = new VorbisFloor();
		}

		var4 = var1.method1161(6) + 1;
		field398 = new VorbisResidue[var4];

		for (var5 = 0; var5 < var4; ++var5) {
			field398[var5] = new VorbisResidue();
		}

		var5 = var1.method1161(6) + 1;
		field399 = new VorbisMapping[var5];

		for (var6 = 0; var6 < var5; ++var6) {
			field399[var6] = new VorbisMapping();
		}

		var6 = var1.method1161(6) + 1;
		field400 = new boolean[var6];
		field401 = new int[var6];

		for (int var7 = 0; var7 < var6; ++var7) {
			field400[var7] = var1.method1162() != 0;
			var1.method1161(16);
			var1.method1161(16);
			field401[var7] = var1.method1161(8);
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lnu;)Z"
	)
	static boolean method1103(AbstractArchive var0) {
		if (!field418) {
			byte[] var1 = var0.takeFile(0, 0);
			if (var1 == null) {
				return false;
			}

			method1101(var1);
			field418 = true;
		}

		return true;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Lnu;II)Lcm;"
	)
	@Export("readMusicSample")
	static VorbisSample readMusicSample(AbstractArchive var0, int var1, int var2) {
		if (!method1103(var0)) {
			var0.tryLoadFile(var1, var2);
			return null;
		} else {
			byte[] var3 = var0.takeFile(var1, var2);
			return var3 == null ? null : new VorbisSample(var3);
		}
	}
}
