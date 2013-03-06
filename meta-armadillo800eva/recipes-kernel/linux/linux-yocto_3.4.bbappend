FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE_armadillo800eva = "armadillo800eva"
KBRANCH_DEFAULT_armadillo800eva = "ltsi"
KBRANCH_armadillo800eva = "${KBRANCH_DEFAULT}"
KMACHINE_armadillo800eva = "armadillo800eva"

LINUX_VERSION = "3.4.25"

SRCREV_machine_armadillo800eva ?= "36273d8aa7bdf7744007ca8388ffccc8e74d933f"

SRC_URI_append_armadillo800eva = " \
	file://defconfig \
	file://armadillo800eva-standard.scc \
	file://armadillo800eva.scc \
	file://user-patches.scc \
	file://armadillo800eva.cfg \
	file://user-config.cfg \
	file://missing_required.cfg \
	file://required_redefinition.txt \
	file://specified_non_hdw.cfg \
	"
