from django.contrib.auth.models import AbstractUser

from django.db import models

class CustomUser(AbstractUser):
    pass
    point = models.IntegerField(default=0)
    recorded = models.IntegerField(default=0)
    filter1 = models.BooleanField(default=False)
    filter2 = models.BooleanField(default=False)
    filter3 = models.BooleanField(default=False)
    filter4 = models.BooleanField(default=False)
    filter5 = models.BooleanField(default=False)
    filter6 = models.BooleanField(default=False)
    filter7 = models.BooleanField(default=False)
    filter8 = models.BooleanField(default=False)
    filter9 = models.BooleanField(default=False)
    filter10 = models.BooleanField(default=False)


# Create your models here.
