from django.contrib import admin

from django.contrib.auth import get_user_model
from django.contrib.auth.admin import UserAdmin

from .forms import CustomUserCreationForm, CustomUserChangeForm
from .models import CustomUser

class CustomUserAdmin(UserAdmin):
    add_form = CustomUserCreationForm
    form = CustomUserChangeForm
    model = CustomUser
    list_display = ['email', 'username', 'point', 'recorded', 'filter1', 'filter2', 'filter3', 'filter4', 'filter5', 'filter6', 'filter7', 'filter8', 'filter9', 'filter10']
    #문제 시 point column 제거
admin.site.register(CustomUser, CustomUserAdmin)


#from .models import Blog

#admin.site.register(Blog)

#from bookmarks.models import Link, Bookmark, Tag, SharedBookmark
# Register your models here.
