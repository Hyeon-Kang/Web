# users/models.py
from django.contrib.auth.models import AbstractUser
from django.db import models

class CustomUser(AbstractUser):
    pass
    point = models.IntegerField(default=0)
    filter1 = models.BoolField(default=False)
    filter2 = models.BoolField(default=False)
    filter3 = models.BoolField(default=False)
    filter4 = models.BoolField(default=False)
    filter5 = models.BoolField(default=False)
    filter6 = models.BooleanField(default=False)
    # add additional fields in here
    #email.models.EmailField(unique = True)
    #email.models.CharField(max_length = 30)

class filter_list(models.Model):
