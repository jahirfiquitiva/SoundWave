# config.py
import os


class SessionConfig:
    """Set app config vars."""
    SECRET_KEY = os.urandom(24)
    SESSION_TYPE = None
    SESSION_COOKIE_NAME = 'session name'
    SESSION_PERMANENT = True
    PERMANENT_SESSION_LIFETIME = 2678400
