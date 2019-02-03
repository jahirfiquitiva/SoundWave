class bcolors:
    PURPLE = '\033[95m'
    BLUE = '\033[94m'
    GREEN = '\033[92m'
    YELLOW = '\033[93m'
    RED = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'


def __internal_format_msg__(color: str, message: str, bold=False, underline=False):
    msg_format = color
    if bold:
        msg_format += bcolors.BOLD
    if underline:
        msg_format += bcolors.UNDERLINE
    return msg_format + message + bcolors.ENDC


def print_info(message, bold=False, underline=False):
    print(__internal_format_msg__(bcolors.GREEN, message, bold, underline))


def print_warn(message, bold=False, underline=False):
    print(__internal_format_msg__(bcolors.YELLOW, message, bold, underline))


def print_error(message, bold=False, underline=False):
    print(__internal_format_msg__(bcolors.RED, message, bold, underline))


def prnt(message, bold=False, underline=False):
    print(__internal_format_msg__(bcolors.BLUE, message, bold, underline))
