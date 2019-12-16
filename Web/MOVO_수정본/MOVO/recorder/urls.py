
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

from django.urls import path
from .views import SignUpView
from .views import get_point
from .views import get_time
from .views import buy_filter1
from .views import buy_filter2
from .views import buy_filter3
from .views import buy_filter4
from .views import buy_filter5
from .views import buy_filter6
from .views import buy_filter7
from .views import buy_filter8
from .views import buy_filter9
from .views import buy_filter10


from django.conf import settings
from django.conf.urls import url, include # include 추가
from django.conf.urls.static import static
from recorder import views

app_name = 'recorder'

urlpatterns = [
    url(r'^$', views.index, name='index'),
    url(r'^upload/', views.upload, name='upload'),
    url(r'^convert/', views.convert, name='convert'),
    path('signup/', SignUpView.as_view(), name='signup'),
    path('get_point/', views.get_point, name='get_point'),
    path('get_time/', views.get_time, name='get_time'),
    path('buy_filter1/', views.buy_filter1, name='buy_filter1'),
    path('buy_filter2/', views.buy_filter2, name='buy_filter2'),
    path('buy_filter3/', views.buy_filter3, name='buy_filter3'),
    path('buy_filter4/', views.buy_filter4, name='buy_filter4'),
    path('buy_filter5/', views.buy_filter5, name='buy_filter5'),
    path('buy_filter6/', views.buy_filter6, name='buy_filter6'),
    path('buy_filter7/', views.buy_filter7, name='buy_filter7'),
    path('buy_filter8/', views.buy_filter8, name='buy_filter8'),
    path('buy_filter9/', views.buy_filter9, name='buy_filter9'),
    path('buy_filter10/', views.buy_filter10, name='buy_filter10'),

] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
