from django import forms
from django.contrib.auth.forms import UserCreationForm, UserChangeForm # 사용쟈 정의 User model
from .models import Account


class AccountCreationForm(UserCreationForm):
    password_check = forms.CharField(max_length=200, widget=forms.PasswordInput()) # password 오탈자 검사

    field_order=['username','password','password_check','email', 'point']
    class Meta(UserCreationForm.Meta):
        model = Account
        fields = ('username', 'email')

# fields 속성에 명시되지 않았다고 DB에 없는 것이 아니다.

class AccountChangeForm(UserChangeForm):

    class Meta:
        model = Account
        fields = ('username', 'email')
