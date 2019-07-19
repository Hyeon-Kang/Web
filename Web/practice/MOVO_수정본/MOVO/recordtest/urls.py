"""recordtest URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.conf.urls import url, include #include 추가 import
from django.urls import include, path
from django.conf import settings # 문제시 제거

from django.views.generic.base import TemplateView

# from django.contrib.auth import views
# import gooin.views
#from .views import home
#app_name ="social"

urlpatterns = [
    url(r'^recorder/', include('recorder.urls', namespace="recorder")),
    url(r'^admin/', admin.site.urls),
    #url(r'^users/', include('users.urls')),
    url(r'^recorder/', include('django.contrib.auth.urls')),

    #path('auth/', include('social_django.urls', namespace='social')),


    #url(r'^social/', include('social_django.urls', namespace='social')),
    #url('', include('social_django.urls', namespace='social')),
    #url(r'^login/$', views.login, name='login'),
    #url(r'^logout/$', views.logout, name='logout'),
    # url(r'^auth/', include('social_django.urls', namespace='social')),  # <- Here
    #url(r'^$', home, name='home'),
    # path('', goologin.views.home, name = "home"),

]
