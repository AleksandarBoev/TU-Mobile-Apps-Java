package tu.practise.databaseproject;

import android.os.Parcel;
import android.os.Parcelable;

public class StudentViewModel implements Parcelable {
    private String name;
    private String lastName;

    public StudentViewModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected StudentViewModel(Parcel in) {
        name = in.readString();
        lastName = in.readString();
    }

    public static final Creator<StudentViewModel> CREATOR = new Creator<StudentViewModel>() {
        @Override
        public StudentViewModel createFromParcel(Parcel in) {
            return new StudentViewModel(in);
        }

        @Override
        public StudentViewModel[] newArray(int size) {
            return new StudentViewModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
    }
}
