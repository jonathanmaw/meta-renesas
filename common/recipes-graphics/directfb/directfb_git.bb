require directfb_git.inc

RV = "1.7-0"
PR = "r3"
S = "${WORKDIR}/git"

DEPENDS += "flux-native sysfsutils libuiomux libdrm linux-fusion khronos-headers"

SRC_URI += "file://fix-compilation-with-zlib.patch \
            file://fixsepbuild.patch \
            file://directfbrc \
            file://0001-drmkms-in-drmkmsPlaneTestRegion-and-drmkmsPlayeSetRe.patch \
            file://0002-drmkms-fix-framebuffer-allocation-size.patch \
            file://0003-drmkms-replace-DLCONF_-with-CLRCF_-where-appropriate.patch"

SRCREV = "522349046b437a7d03665cbc8cb42c97dca6c69d"

EXTRA_OECONF = "\
  --enable-freetype \
  --enable-zlib \
  --disable-sdl \
  --disable-vnc \
  --disable-x11 \
  --disable-imlib2 \
  --disable-mesa \
  --enable-trace \
  --enable-debug \
  --enable-debug-support \
  --disable-one \
  --enable-multi \
  --enable-multicore \
  --enable-network \
  --enable-voodoo \
  --enable-sawman \
  --enable-fusiondale \
  --enable-fusionsound \
  --disable-unique \
  --with-tests \
  --with-fs-drivers=dummy \
  --with-inputdrivers=linuxinput \
  --without-smooth-scaling \
  --without-vorbis \
  --enable-fbdev \
  --enable-png \
  --disable-x11vdpau \
  --disable-devmem \
  --disable-linotype \
  --enable-drmkms \
  --enable-idirectfbgl-egl \
  --with-gfxdrivers=gp2d \
"

TARGET_CFLAGS += "-I${STAGING_INCDIR}/libdrm"

do_configure_prepend() {
	export GP2D_LIBS="-ldrm"
	export DRMKMS_LIBS="-ldrm -lkms"
}

do_install_append () {
	install -d ${D}/etc
        install -m 0644 ${WORKDIR}/directfbrc ${D}/etc/
	rm -rf ${D}/usr/lib/nm-n.*
}

LEAD_SONAME = "libdirectfb-1.7.so.0"

